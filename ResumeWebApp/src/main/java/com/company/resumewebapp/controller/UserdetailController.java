package com.company.resumewebapp.controller;

import com.company.resumewebapp.util.ControllerUtil;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet(name = "UserdetailController", value = "/userdetail")
public class UserdetailController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();
    CountryDaoInter countryDao = Context.instanceCountryDao();
    EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().equals("")) {
                throw new IllegalArgumentException("user id is null");
            }
            int userId = Integer.parseInt(userIdStr);
            User u = userDao.getById(userId);
            if (u == null) {
                throw  new IllegalArgumentException("user not found");
            }
            request.setAttribute("u", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
        } catch (Exception ex) {
            ControllerUtil.errorPage(response, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User u = userDao.getById(id);

        try {
            if (request.getParameter("action").equals("updateProfile")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String birthdateStr = request.getParameter("birthdate");
                Date birthdate = new Date(sdf.parse(birthdateStr).getTime());
                String address = request.getParameter("address");
                String profileDesc = request.getParameter("profileDesc");
                int nationalityId = Integer.parseInt(request.getParameter("nationality"));
                int countryId = Integer.parseInt(request.getParameter("country"));

                u.setName(name);
                u.setSurname(surname);
                u.setEmail(email);
                u.setPhone(phone);
                u.setBrithdate(birthdate);
                u.setAddress(address);
                u.setProfileDescription(profileDesc);
                u.getNationality().setId(nationalityId);
                u.getBirthplace().setId(countryId);
                userDao.updateUser(u);
            } else if (request.getParameter("action").equals("addHistory")) {
                String company = request.getParameter("company");
                Date beginDate = new Date(sdf.parse(request.getParameter("beginDate")).getTime());
                Date endDate = new Date(sdf.parse(request.getParameter("endDate")).getTime());
                String jobDesc = request.getParameter("jobDesc");
                EmploymentHistory employmentHistory = new EmploymentHistory(null, company, beginDate, endDate, jobDesc, u);
                employmentHistoryDao.addEmploymentHistory(employmentHistory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //response.sendRedirect("users");
    }
}
