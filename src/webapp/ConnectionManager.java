package webapp;

/**
 * Created by AnaBel�n on 24/01/2017.
 */
import java.sql.*;

public class ConnectionManager {
    static Connection con;
    static String url;
    static String username;
    static String password;
    public static Connection getConnection() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
    	String username = ("usersql");
    	String password = ("sql1234");
    	String url = "jdbc:derby://localhost:1527/C:/Users/AnaBel�n/dbderbynet;create=true";
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        
        try {
            con = DriverManager.getConnection(url, username, password);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}