package webapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class ListProducts {
	static Connection currentCon = null;
    static ResultSet rs = null;
    
    public static LinkedList<ProductBean> getProducts(UserBean user){
    	Statement stmt = null;
    	LinkedList<ProductBean> listProducts=new LinkedList<ProductBean>();
    	int userId=user.getId();
    	String query="Select * from products";
    	
    	try{
    		currentCon = ConnectionManager.getConnection();
    		stmt = currentCon.createStatement();
    		rs = stmt.executeQuery(query);
    		while (rs.next())
    		{
    			ProductBean product = new ProductBean();
    			product.setProductId(rs.getInt("ProductID"));
    			product.setUserId(rs.getInt("UserID"));
    			product.setProduct(rs.getString("productName"));
    			product.setDescription(rs.getString("productDescription"));
    			product.setPrice(rs.getFloat("productPrice"));
                if(product.getUserId()==userId){
                listProducts.add(product);
                }
    		}
    		rs.close();
    		stmt.close();
    		currentCon.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	return listProducts;
    }
    
    public static ProductBean getProductById(int productID){
    	Statement stmt = null;
    	String query = "select * from products where ProductID="+productID;
    	ProductBean product = new ProductBean();
    	try{
    		currentCon = ConnectionManager.getConnection();
    		stmt = currentCon.createStatement();
    		rs = stmt.executeQuery(query);
    		while (rs.next())
    		{
    			product.setProductId(rs.getInt("ProductID"));
    			product.setUserId(rs.getInt("UserID"));
    			product.setProduct(rs.getString("productName"));
    			product.setDescription(rs.getString("productDescription"));
    			product.setPrice(rs.getFloat("productPrice"));
    		}
    		rs.close();
    		stmt.close();
    		currentCon.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	return product;
    }
} 

