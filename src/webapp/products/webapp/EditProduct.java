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
public class EditProduct  extends HttpServlet{
	static Connection currentCon = null;
    static ResultSet rs = null;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	int id = Integer.parseInt(request.getParameter("id"));
        	String name = request.getParameter("productName");
        	String description =request.getParameter("productDescription");
        	float price = Float.parseFloat(request.getParameter("productPrice"));
    	
        	Statement stmt = null;
        	String query= "UPDATE products SET productName='"+name+"',productDescription='"+description+"', productPrice="+price+" WHERE ProductID="+id;
        	System.out.println("For editing products -> "+id+" Query= "+query);

    	try { //connect to DB
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