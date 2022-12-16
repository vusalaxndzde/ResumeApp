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
<!DOCTYPE html>
<html>
<head>
    <title>User jsp</title>
</head>
<body>
    <%
        User u = (User) request.getAttribute("u");
    %>
    <h1>User</h1>
    <div>
        <form action="userdetail" method="post">
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
