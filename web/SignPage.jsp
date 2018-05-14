<%--
  Created by IntelliJ IDEA.
  User: AnaBelén
  Date: 24/01/2017
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: AnaBelén
  Date: 24/01/2017
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>

<%@page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>New User</title>
    <link href="/css/newUserStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
    <form action="SignServlet">
        <div class="container">

            <label><b>Username</b></label><br></br>
            <input type="text" placeholder="Enter Username" name="unsername" required><br></br>

            <label><b>Password</b></label><br></br>
            <input type="password" placeholder="Enter Password" name="password" required><br></br>

            <button type="submit">Sign up</button>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <span class="newuser"><a href="/LoginPage.jsp">Cancel</a></span>
        </div>
    </form>
</body>
</html>