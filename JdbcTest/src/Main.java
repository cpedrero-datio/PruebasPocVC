import java.sql.*;
import java.util.Properties;

/**
 * Created by cpedrero on 22/02/16.
 */
public class Main {

public static void main(String[] args) throws Exception {
    Class.forName("com.stratio.jdbc.core.jdbc4.StratioDriver");
    Properties connectionProps = new Properties();
    connectionProps.setProperty("user","");
    connectionProps.setProperty("password","");
   /* Connection conn = DriverManager.getConnection("jdbc:simba://Server=datio02.stratio.com:13420;PWD=pwd;UID=uid",
            connectionProps);
    Statement stm = conn.createStatement();
    for (int i = 0; i < 10; i++) {
        ResultSet rs = stm.executeQuery("SHOW TABLES");
        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
        }
        rs.close();
    }
    stm.close();
    conn.close();*/
    Connection conn  = DriverManager.getConnection("jdbc:simba://Server=datio02.stratio.com:13420;PWD=pwd;UID=uid",
            connectionProps);
    Statement stm = conn.createStatement();
    for (int i = 0; i < 10; i++) {
        ResultSet rs2 = stm.executeQuery("select id, city, name from cassandrakeyspace.cassandrausers limit 2");
        while (rs2.next()) {
            System.out.println(rs2.getString(1));
            System.out.println(rs2.getString(2));
        }
        rs2.close();
    }
    stm.close();
    conn.close();

    Connection conn2  = DriverManager.getConnection("jdbc:simba://Server=datio02.stratio.com:13420;PWD=pwd;UID=uid",
            connectionProps);
    Statement stm1 = conn2.createStatement();
    for (int i = 0; i < 10; i++) {
        ResultSet rs2 = stm1.executeQuery("select id, city, name from cassandrakeyspace.cassandrausers limit 2");
        while (rs2.next()) {
            System.out.println(rs2.getString(1));
            System.out.println(rs2.getString(2));
        }
        rs2.close();
    }
    stm1.close();
    conn2.close();
}
}
