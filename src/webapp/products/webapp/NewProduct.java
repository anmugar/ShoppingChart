package webapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NewProduct  extends HttpServlet{
	static Connection currentCon = null;
    static ResultSet rs = null;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        	
    		UserBean user = (UserBean)request.getSession(true).getAttribute("currentSessionUser");
    		int id = user.getId();
    		
        	String name = request.getParameter("productName");
        	String description =request.getParameter("productDescription");
        	String price =request.getParameter("productPrice");
    	
        	Statement stmt = null;
        	String query= "INSERT INTO products(UserID, productName, productDescription, productPrice) VALUES ("+id+",'"+name+"','"+description+"',"+price+")";
        	System.out.println("For adding new products -> "+id+" Query= "+query);
    	try { 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(query);
            response.sendRedirect("main.jsp");
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
}

	
    
