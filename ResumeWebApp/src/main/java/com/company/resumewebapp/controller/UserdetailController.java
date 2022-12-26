package com.company.resumewebapp.controller;

import com.company.resumewebapp.util.ControllerUtil;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserdetailController", value = "/userdetail")
public class UserdetailController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");

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
        System.out.println(id);
        User u = userDao.getById(id);

        if (request.getParameter("action").equals("updateProfile")) {
            try {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String birthdateStr = request.getParameter("birthdate");
                System.out.println(birthdateStr);
                Date birthdate = new Date(sdf.parse(birthdateStr).getTime());
                System.out.println(sdf.parse(birthdateStr));
                String address = request.getParameter("address");
                String nationality = request.getParameter("nationality");
                String country = request.getParameter("country");
                String profileDesc = request.getParameter("profileDesc");
            } catch (Exception ex) {
                ex.printStackTrace();
            }



            userDao.updateUser(u);
        } else if (request.getParameter("action").equals("delete")) {
            userDao.removeUser(id);
        }
        response.sendRedirect("users");
    }
}
