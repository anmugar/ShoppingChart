package webapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteProduct  extends HttpServlet{
	static Connection currentCon = null;
    static ResultSet rs = null;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	String productid = request.getParameter("id");
        	int id = Integer.parseInt(productid);
        	System.out.println("ProductID = "+id);
    	
        	Statement stmt = null;
        	String query= "Delete from products where ProductID="+id;

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
    	
    }

	
    
}