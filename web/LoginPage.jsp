
<%--
  Created by IntelliJ IDEA.
  User: AnaBelén
  Date: 22/01/2017
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Login Page</title>
    <link href="/css/loginPageStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
    <form action="LoginServlet">
        <div class="container">

            <label><b>Username</b></label><br></br>
            <input type="text" placeholder="Enter Username" name="username" required><br></br>

            <label><b>Password</b></label><br></br>
            <input type="password" placeholder="Enter Password" name="password" required><br></br>

            <button type="submit">Login</button>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <span class="newuser"><a href="/SignPage.jsp">New User?</a></span>
        </div>
    </form>
</body>
</html>
