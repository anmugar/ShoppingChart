package webapp;

/**
 * Created by AnaBelén on 24/01/2017.
 */
import java.sql.*;
import java.util.*;

public class ConnectionManager {
    static Connection con;
    static String url;
    public static Connection getConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      //  String url = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;databaseName=Products;integratedSecurity=true";
        String url = "jdbc:derby:/localhost:1527/dbderbynet;create=true";
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        // assuming "DataSource" is your DataSource name Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        try {
            con = DriverManager.getConnection(url);
            // assuming your SQL Server's username is "username" // and password is "password"
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}