package com.company.resumewebapp.controller;

import com.company.resumewebapp.util.ControllerUtil;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            ControllerUtil.errorPage(response, "There is no user such email");
        } else {
            if (password.equals(user.getPassword())) {
                request.getSession().setAttribute("loggedInUser", user);
                response.sendRedirect("users");
            }
        }
    }
}
