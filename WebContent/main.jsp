<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" %>
<%@ page import = "webapp.UserBean"%> 
<%@ page import = "webapp.ProductBean"%> 
<%@ page import = "webapp.ListProducts"%> 
<%@ page import = "java.util.LinkedList"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/webapp/css/ListProductsStyle.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <title>Main panel</title>
</head>
<body>
<% 
UserBean user = (UserBean)request.getSession(true).getAttribute("currentSessionUser"); 
String username = user.getUsername();
%>
	<ul>
	<li><a href="main.jsp">Products</a></li>
	<li><a data-toggle="modal" data-target="#modalAdd">New product</a></li>
	<li><a href="about.html">About</a></li>
	<li style="float:right"><a class="active" href="LogoutServlet">Logout</a></li>
	</ul>
	<div class="container">
		<h2>Products</h2>
  		<p>Welcome user <b><%=username%></b></p>                                                                                      
  		<div class="table-responsive">          
  			<table class="table">
    			<thead>
      			<tr>
        			<th>#</th>
        			<th>Name</th>
        			<th>Description</th>
        			<th>Price</th>
        			<th>	</th>
        			<th>	</th>
      			</tr>
    			</thead>
    			<tbody>  
<%
LinkedList<ProductBean> listProducts = ListProducts.getProducts(user);
for (int i=0;i<listProducts.size();i++)
{
%>
				<tr>
					<td> <%=(i+1) %> </td>
					<td> <%=listProducts.get(i).getProduct() %> </td>
					<td> <%=listProducts.get(i).getDescription() %> </td>
					<td> <%=listProducts.get(i).getPrice() %> EUR </td>
					<td> 
						<form action="editproduct.jsp" >
						<input type=hidden name="id" value="<%=listProducts.get(i).getProductId()%>">
						<button type="submit">Edit</button>
						</form>	
					</td>
					<td> 
						<form action="DeleteProduct" >
						<input type=hidden name="id" value="<%=listProducts.get(i).getProductId()%>">
						<button type="submit">Delete</button>
						</form>	
					</td>
				</tr>
<%}%>
    			</tbody>
  			</table>
  		</div>
	</div>
<!-- 1 -->
<div class="modal fade" id="modalAdd" >
 
    <div class="modal-dialog">
		<form action="NewProduct">
      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header">
          	<!--  <button type="button" class="close" data-dismiss="modal">&times;</button>-->
          	<h4 class="modal-title">New Product</h4>
        	</div>
        	<div class="modal-body">
          	<table class="table">
    			<thead>
      				<tr>
        			<th>Name</th>
        			<th>Description</th>
        			<th>Price (EUR)</th>
      				</tr>
    			</thead>
    		<tbody>
      			<tr>
        		<td><input type="text" class="form-control" name="productName" required></td>
        		<td><input type="text" class="form-control" name="productDescription" required></td>
        		<td><input type="text" class="form-control" name="productPrice" required></td>
      			</tr>
    		</tbody>
  			</table>
        	</div>
        	<div class="modal-footer">
          		<button type="submit" class="btn btn-default" >Add</button>
        	</div>
      	</div>
      	</form>
    </div>
</div>
<!-- 1 -->

</body>
</html>