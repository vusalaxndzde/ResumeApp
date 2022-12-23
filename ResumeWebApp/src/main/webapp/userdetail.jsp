<%@ page import="com.mycompany.entity.User" %>
<%@ page import="com.mycompany.entity.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.dao.inter.CountryDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.entity.EmploymentHistory" %>
<%@ page import="com.mycompany.dao.inter.EmploymentHistoryDaoInter" %>
<%@ page import="com.mycompany.dao.inter.UserSkillDaoInter" %>
<%@ page import="com.mycompany.entity.UserSkill" %>
<%--
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
    <title>User Detail</title>
    <link rel="stylesheet" href="assets/css/userdetail.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="assets/js/userdetail.js"></script>
</head>
<body style="background-color: #e0e1e1">
    <%
        User u = (User) request.getAttribute("u");
        CountryDaoInter countryDao = Context.instanceCountryDao();
        List<Country> countries = countryDao.getAllCountry();
        EmploymentHistoryDaoInter empHistoryDao = Context.instanceEmploymentHistoryDao();
        List<EmploymentHistory> userEmpHistories = empHistoryDao.getEmploymentHistoryByUserId(u.getId());
        UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
        List<UserSkill> userSkills = userSkillDao.getAllUserSkillByUserId(u.getId());
    %>
    <div class="container my-container" style="background-color: #efefef; border-radius: 15px">
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
                    <input type="email" class="form-control" id="inputEmail" value="<%=u.getEmail()%>" placeholder="Email">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPhone">Phone</label>
                    <input type="text" class="form-control" id="inputPhone" value="<%=u.getPhone()%>" placeholder="Phone">
                </div>
            </div>
            <div class="form-row my-margin-bottom">
                <div class="form-group col-2">
                    <label for="inputBirthdate">Birthdate</label>
                    <input type="date" class="form-control" id="inputBirthdate" value="<%=u.getBrithdate()%>">
                </div>
            </div>
            <!-- Address country -->
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" value="<%=u.getAddress()%>" placeholder="1234 Main St">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Address 2</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
            </div>
            <div class="form-row my-margin">
                <div class="form-group col-md-6">
                    <label for="inputCity">Nationality</label>
                    <input type="text" class="form-control" id="inputCity" value="<%=u.getNationality().getNationality()%>">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputCountry">Country</label>
                    <select id="inputCountry" class="form-control">
                        <option selected><%=u.getBirthplace().getName()%></option>
                        <%for (Country country : countries) {
                            if (country.getName().equals(u.getBirthplace().getName())) {
                                continue;
                            }
                        %>
                        <option ><%=country.getName()%></option >
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
                <div class="form-group my-margin-bottom">
                    <label for="jobDescTextarea">Job description</label>
                    <textarea class="form-control" id="jobDescTextarea" name="jobDesc" rows="5"><%=empHistory.getJobDescription()%></textarea>
                </div>
                <hr>
                <%}%>
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
                <button type="button" class="btn btn-success" id="addSkill" onclick="addSkillTd()"></button>
            </div>
            <!-- Update button -->
            <button type="submit" class="btn btn-success my-margin-bottom" name="submit" value="Update">Update</button>
            <button type="submit" class="btn btn-secondary my-margin-bottom" name="submit" value="Back">Back</button>
        </form>
    </div>
</body>
</html>
