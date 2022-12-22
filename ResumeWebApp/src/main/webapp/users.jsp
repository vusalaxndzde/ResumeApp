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
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <script type="text/javascript" src="assets/js/users.js"></script>
</head>
<body>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
    %>
    <div class="container mycontainer">
        <div class="row">
            <div class="col-4">
                <form action="users" method="get">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
                    </div>
                    <div class="form-group">
                        <label for="surname">Surname:</label>
                        <input type="text" class="form-control" id="surname" name="surname" placeholder="Enter surname">
                    </div>
                    <div class="form-group">
                        <label for="nid">Nationality:</label>
                        <input type="text" class="form-control" id="nid" name="nationality" placeholder="Enter nationality">
                    </div>
                    <input type="submit" class="btn btn-primary" id="search" name="search" value="Search">
                </form>
            </div>
        </div>
        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Country</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%for (User user : users) {%>
                    <tr>
                        <td><%=user.getName()%></td>
                        <td><%=user.getSurname()%></td>
                        <td><%=user.getBirthplace().getName() == null ? "N/A" : user.getBirthplace().getName()%></td>
                        <td style="width: 10px">
                            <form action="userdetail" method="post">
                                <input type="hidden" name="id" value="<%=user.getId()%>">
                                <input type="hidden" name="action" value="delete">
                                <button class="btn btn-danger" type="submit" value="delete">
                                    <i class="fa-solid fa-trash-can"></i>
                                </button>
                            </form>
                        </td>
                        <td style="width: 10px">
                            <form action="userdetail" method="get">
                                <input type="hidden" name="id" value="<%=user.getId()%>">
                                <input type="hidden" name="action" value="update">
                                <button class="btn btn-secondary" type="submit" value="update">
                                    <i class="fa-sharp fa-solid fa-pen"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
