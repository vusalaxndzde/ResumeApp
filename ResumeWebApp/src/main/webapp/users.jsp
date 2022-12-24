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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
    <%
        User u = (User) request.getSession().getAttribute("loggedInUser");
        List<User> users = (List<User>) request.getAttribute("users");
    %>
    <h1>Welcome, <%=u.getName()%></h1>
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
                            <button class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter"
                                    type="submit" value="delete" onclick="setIdForDelete('<%=user.getId()%>')">
                                <i class="fa-solid fa-trash-can"></i>
                            </button>
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

    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <form action="userdetail" method="post">
                        <input type="hidden" id="idForDelete" name="id">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger" name="action" value="delete">Yes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
