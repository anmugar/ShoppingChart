<%@page import="webapp.ListProducts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "webapp.ProductBean"%> 
<%@ page import = "webapp.ListProducts"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/webapp/css/ListProductsStyle.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Edit product</title>
</head>
<body>
	<ul>
	<li><a href="main.jsp">Products</a></li>
	<li><a href="about.html">About</a></li>
	<li style="float:right"><a class="active" href="LogoutServlet">Logout</a></li>
	</ul>

<%int id =Integer.parseInt(request.getParameter("id")) ; 
ProductBean product = ListProducts.getProductById(id);
%>
<div class="modal-dialog">
		<form action="EditProduct">
      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header">
          	<h4 class="modal-title">Edit Product</h4>
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
        		<td><input type="text" class="form-control" name="productName" value="<%=product.getProduct()%>"></td>
        		<td><input type="text" class="form-control" name="productDescription" value="<%=product.getDescription() %>"></td>
        		<td><input type="text" class="form-control" name="productPrice" value="<%=product.getPrice() %>"></td>
      			</tr>
    		</tbody>
  			</table>
        	</div>
        	<input type="hidden"name="id" value="<%=id%>">
        	<div class="modal-footer">
          		<button type="submit" class="btn btn-default" >Save changes</button>
        	</div>
      	</div>
      	<!-- <input type=hidden name="id"> -->
      	</form>
    </div>

</body>
</html>