<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="com.mycompany.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.12.2022
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User jsp</title>
</head>
<body>
    <%
        UserDaoInter userDao = Context.instanceUserDao();
        User u = userDao.getById(1);
    %>
    <h1>User</h1>
    <div>
        <form action="UserController" method="post">
            <input type="hidden" name="id" value="<%=u.getId()%>">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" value="<%=u.getName()%>"><br><br>
            <label for="surname">Surname:</label><br>
            <input type="text" id="surname" name="surname" value="<%=u.getSurname()%>"><br><br>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</body>
</html>
