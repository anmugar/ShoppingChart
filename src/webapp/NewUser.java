package webapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NewUser  extends HttpServlet{
	static Connection currentCon = null;
    static ResultSet rs = null;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        	
    	UserBean user = new UserBean();
    	String name = request.getParameter("username");
    	String pass = request.getParameter("password");
    	user.setUserName(name);
    	user.setPassword(pass);
    	Statement stmt = null;
    	String query= "INSERT INTO users(username, password) VALUES ('"+name+"','"+pass+"')";
    	System.out.println("Query= "+query);
    	
    	boolean exist = UserDatabase.signup(user);
    	if(!exist){
        	try { //connect to DB
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(query);
            response.sendRedirect("login.html");
        	}
        	catch(Exception e)
        	{
        		System.out.println(e);
        	}
        	finally {
                
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
    	}
    	else{
    		response.sendRedirect("errorsign.html");
    	}
    	
    	
    }
}