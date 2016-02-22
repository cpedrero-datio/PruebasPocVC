import java.sql.*;
import java.util.Properties;




/**
 * Created by egarcia on 15/02/16.
 */
public class JDBCTest{
    public static void main(String arg[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.stratio.jdbc.core.jdbc4.StratioDriver");

        Properties connectionProps = new Properties();
        connectionProps.put("user","");
        connectionProps.put("password","");

        Connection conn = DriverManager.getConnection("jdbc:simba://Server=mike04.stratio.com:13420;PWD=pwd;UID=uid", connectionProps);

        System.out.println("Connected to database");

        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery("SHOW TABLES");

        while (res.next()){
            System.out.println(res.getString(1));
            System.out.println(res.getString(2));

        }

        res.close();
        st.close();
        conn.close();

    }
}
