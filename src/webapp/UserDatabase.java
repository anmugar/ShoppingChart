package webapp;

/**
 * Created by AnaBelén on 24/01/2017.
 */
import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDatabase {
    static Connection currentCon = null;
    static ResultSet rs = null;

    public static UserBean login(UserBean bean) {

        Statement stmt = null;
        String user = bean.getUsername();
        String pass = bean.getPassword();
        String query = "select * from Users where username='" + user + "' AND password='" + pass + "'";

        //Checking parameters
        System.out.println("Your user name is " + user);
        System.out.println("Your password is " + pass);
        System.out.println("Query: "+query);

        try { //connect to DB
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(query);
            boolean more = rs.next(); // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user!");
                bean.setValid(false);
            } //if user exists set the isValid variable to true
            else
                if (more) {
                    System.out.println("Welcome " + user);
                    bean.setValid(true);
            }
        }
        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (Exception e) {}
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {}
                stmt = null;
            }
            if (currentCon != null) {
                try {
                    currentCon.close();
                }
                catch (Exception e) { }
                currentCon = null;
            }
        }
        return bean;
    }
}