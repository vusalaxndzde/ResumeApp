<%@ page import="com.mycompany.entity.User" %>
<%@ page import="com.mycompany.entity.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.entity.EmploymentHistory" %>
<%@ page import="com.mycompany.entity.UserSkill" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Detail</title>
    <link rel="stylesheet" href="assets/css/userdetail.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="assets/js/userdetail.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body style="background-color: #e0e1e1">
    <%
        User u = (User) request.getAttribute("user");
        List<Country> countries = (List<Country>) request.getAttribute("countries");
        List<EmploymentHistory> userEmpHistories = (List<EmploymentHistory>) request.getAttribute("userEmpHistories");
        List<UserSkill> userSkills = (List<UserSkill>) request.getAttribute("userSkills");
    %>
    <div class="container my-container resume-wrapper-inner mx-auto text-start bg-white shadow-lg" style="background-color: #efefef; border-radius: 15px">
        <form action="userdetail" method="post">
            <div style="height: 15px">
                <input type="hidden" name="id" value="<%=u.getId()%>">
            </div>
            <h4>User profile</h4>
            <!-- Name and Surname -->
            <div class="form-row my-margin-bottom">
                <div class="form-group col-4">
                    <label for="inputName">Name</label>
                    <input type="text" class="form-control" id="inputName" name="name" value="<%=u.getName()%>" placeholder="First name">
                </div>
                <div class="form-group col-4">
                    <label for="inputSurname">Surname</label>
                    <input type="text" class="form-control" id="inputSurname" name="surname" value="<%=u.getSurname()%>" placeholder="Last name">
                </div>
            </div>
            <!-- Email phone birth-->
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputEmail">Email</label>
                    <input type="email" class="form-control" id="inputEmail" name="email" value="<%=u.getEmail()%>" placeholder="Email">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPhone">Phone</label>
                    <input type="text" class="form-control" id="inputPhone" name="phone" value="<%=u.getPhone()%>" placeholder="Phone">
                </div>
            </div>
            <div class="form-row my-margin-bottom">
                <div class="form-group col-2">
                    <label for="inputBirthdate">Birthdate</label>
                    <input type="date" class="form-control" id="inputBirthdate" name="birthdate" value="<%=u.getBirthdate()%>">
                </div>
            </div>
            <!-- Address country -->
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" name="address" value="<%=u.getAddress()%>" placeholder="1234 Main St">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Address 2</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
            </div>
            <div class="form-row my-margin">
                <div class="form-group col-md-4">
                    <label for="inputNationality">Nationality</label>
                    <select id="inputNationality" class="form-control" name="nationality">
                        <option value="<%=u.getNationality().getId()%>" selected><%=u.getNationality().getNationality()%></option>
                        <%for (Country nationality : countries) {
                            if (nationality.getNationality().equals(u.getNationality().getNationality())) {
                                continue;
                            }
                        %>
                        <option value="<%=nationality.getId()%>" ><%=nationality.getNationality()%></option >
                        <%}%>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputCountry">Country</label>
                    <select id="inputCountry" class="form-control" name="country">
                        <option value="<%=u.getBirthplace().getId()%>" selected><%=u.getBirthplace().getName()%></option>
                        <%for (Country country : countries) {
                            if (country.getName().equals(u.getBirthplace().getName())) {
                                continue;
                            }
                        %>
                        <option value="<%=country.getId()%>" ><%=country.getName()%></option >
                        <%}%>
                    </select>
                </div>
            </div>
            <hr>
            <!-- Profile description -->
            <div class="form-group my-margin-bottom">
                <label for="profileDescTextarea">Profile description</label>
                <textarea class="form-control" id="profileDescTextarea" name="profileDesc" rows="5"><%=u.getProfileDescription()%></textarea>
            </div>
                <button type="submit" class="btn btn-outline-success" name="action" value="updateProfile">Update profile</button>
        </form>
            <!-- Employment history -->
        <div>
            <form action="userdetail" method="post">
                <div class="form-group my-margin-top">
                    <h4>Employment history</h4><br>
                    <%for (EmploymentHistory empHistory : userEmpHistories) {%>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="headerEmpHistory">Company</label>
                            <input type="text" class="form-control" id="headerEmpHistory" name="company" value="<%=empHistory.getHeader()%>">
                        </div>
                    </div>
                    <div class="form-group form-row">
                        <div class="col-md-12">
                            <label>Begin date / End date</label>
                        </div>
                        <div class="form-group col-md-2">
                            <input type="date" class="form-control" id="beginDate" name="beginDate" value="<%=empHistory.getBeginDate()%>">
                        </div>
                        <div class="form-group col-md-2">
                            <input type="date" class="form-control" id="endDate" name="beginDate" value="<%=empHistory.getEndDate()%>">
                        </div>
                    </div>
                    <div class="form-group form-row my-margin-bottom">
                        <div class="form-group col-md-10">
                            <label for="jobDescTextarea">Job description</label>
                            <textarea class="form-control" id="jobDescTextarea" name="jobDesc" rows="5"><%=empHistory.getJobDescription()%></textarea>
                        </div>
                        <div class="form-group col-md-2">
                            <form action="userdetail" method="get">
                                <input type="hidden" name="historyId" value="<%=empHistory.getId()%>">
                                <input type="hidden" name="id" value="<%=u.getId()%>">
                                <button class="btn btn-danger dltHistoryBtn" type="submit" name="action" value="deleteHistory">
                                    <i class="fa-solid fa-trash-can"></i>
                                </button>
                            </form>
                        </div>
                    </div>
                    <hr>
                    <%}%>
                </div>
                <button type="submit" class="btn btn-outline-success">Update history</button>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                    Add history
                </button>
            </form>
        </div>

        <div class="form-group my-margin-bottom my-margin-top">
                <h4>Skills</h4>
                <table class="table" id="skillTable">
                    <%for (UserSkill userSkill : userSkills) {%>
                    <tr>
                        <td style="width: 400px">
                            <input type="text" class="form-control" value="<%=userSkill.getSkill()%>">
                        </td>
                        <td style="width: 400px">
                            <input type="range" class="form-range" min="0" max="10" id="skillRange" value="<%=userSkill.getPower()%>" >
                        </td>
                        <td style="width: 300px">
                            <button class="btn btn-secondary" type="button" value="update">
                                <i class="fa-solid fa-trash-can"></i>
                            </button>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
                <button type="button" class="btn btn-success" id="addSkill" onclick="addSkillTd()">Add skill</button>
            </div>
        <!-- Update button -->
        <button type="submit" class="btn btn-success my-margin-bottom" name="action" value="update">Update</button>
        <button type="submit" class="btn btn-secondary my-margin-bottom" name="action" value="back">Back</button>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Add history</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="userdetail" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <input type="hidden" name="id" value="<%=u.getId()%>">
                            <div class="form-row">
                                <div class="form-group col-md-8">
                                    <label for="addHeaderEmpHistory">Company</label>
                                    <input type="text" class="form-control" id="addHeaderEmpHistory" name="company">
                                </div>
                            </div>
                            <div class="form-group form-row">
                                <div class="col-md-12">
                                    <label>Begin date / End date</label>
                                </div>
                                <div class="form-group col-md-4">
                                    <input type="date" class="form-control" id="addBeginDate" name="beginDate">
                                </div>
                                <div class="form-group col-md-4">
                                    <input type="date" class="form-control" id="addEndDate" name="endDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="addJobDescTextarea">Job description</label>
                                <textarea class="form-control" id="addJobDescTextarea" name="jobDesc" rows="5"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" name="action" value="addHistory">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
