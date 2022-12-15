<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 15.12.2022
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div style="margin: 250px 0 0 850px; border: 10px solid red; width: 10%">
        <form action="LoginController" method="post">
            <div>
                <label for="username">Username:</label><br>
                <input type="text" id="username" name="username" placeholder="Enter username">
            </div>
            <div>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password" placeholder="Enter password">
            </div>
            <div>
                <button type="submit" name="btn_login">Login</button>
            </div>
        </form>
    </div>
</body>
</html>
