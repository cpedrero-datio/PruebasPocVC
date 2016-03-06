/**
 * Created by egarcia on 16/02/16.
 */
package main.java.org.cassandradatagenerator;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class App
{
    public static void main( String[] args )
    {
        //Create keyspace
        String createKeyspaceQuery = "CREATE KEYSPACE IF NOT EXISTS cassandraKeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };";

        //Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Session object
        Session session = cluster.connect();

        //Execute query
        session.execute(createKeyspaceQuery);

        //USE Keyspace
        session.execute("USE cassandraKeyspace");

        //Session object (to create tables and inserts)
        session = cluster.connect("cassandraKeyspace");

        //Create table
        String createTableQuery = "CREATE TABLE IF NOT EXISTS cassandraUsers(id int PRIMARY KEY, "
                + "name text, "
                + "city text);";
        //Execute query
        session.execute(createTableQuery);

        //Insert data
        for (int i =0; i< Integer.parseInt(args[0]);i++) {
            String insertQuery = "INSERT INTO cassandraUsers (id, name, city)"
                    + " VALUES("+i+" ,'Name"+i+"', 'City"+i+"');";

            //Execute query
            session.execute(insertQuery);
        }

        cluster.close();
        session.close();

        System.out.println("Data created successfully");
    }
}
