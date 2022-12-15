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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
</head>
<body>
    <div style="margin: 250px 0 0 850px">
        <form action="LoginController" method="post">
            <div>
                <i class="fa-solid fa-user"></i>
                <input type="text" id="username" name="username" placeholder="Enter username">
            </div>
            <div>
                <i class="fa-solid fa-lock"></i>
                <input type="password" id="password" name="password" placeholder="Enter password">
            </div>
            <div>
                <button type="submit" name="btn_login">Login</button>
            </div>
        </form>
    </div>
</body>
</html>
