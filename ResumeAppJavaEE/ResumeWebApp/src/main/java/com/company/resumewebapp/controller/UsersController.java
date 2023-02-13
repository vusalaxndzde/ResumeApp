package com.company.resumewebapp.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersController", value = "/users")
public class UsersController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String nationalityIdStr = request.getParameter("nationality");
        Integer nationalityId = null;
        if (nationalityIdStr != null && !nationalityIdStr.trim().equals("")) {
            nationalityId = Integer.valueOf(request.getParameter("nationality"));
        }
        List<User> users = userDao.filter(name, surname, nationalityId);
        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
