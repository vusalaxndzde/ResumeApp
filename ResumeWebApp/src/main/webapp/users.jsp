<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.12.2022
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users jsp</title>
</head>
<body>
    <%
        UserDaoInter userDao = Context.instanceUserDao();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String nationalityIdStr = request.getParameter("nationality");
        Integer nationalityId = null;
        if (nationalityIdStr != null && !nationalityIdStr.trim().equals("")) {
            nationalityId = Integer.valueOf(request.getParameter("nationality"));
        }
        System.out.println(name);
        System.out.println(surname);
        System.out.println(nationalityIdStr);
        List<User> users = userDao.filter(name, surname, nationalityId);
    %>
    <div>
        <form action="users.jsp" method="get">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br><br>
            <label for="surname">Surname:</label><br>
            <input type="text" id="surname" name="surname"><br><br>
            <label for="nid">Nationality:</label><br>
            <input type="text" id="nid" name="nationality"><br><br>
            <input type="submit" name="search" value="Search">
        </form>
    </div>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Country</th>
            </tr>
        </thead>
        <tbody>
            <%for (User user : users) {%>
                <tr>
                    <td><%=user.getName()%></td>
                    <td><%=user.getSurname()%></td>
                    <td><%=user.getNationality() == null ? "N/A" : user.getNationality().getNationality()%></td>
                </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
