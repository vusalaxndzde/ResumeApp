package com.company.resumewebapp.controller;

import com.company.resumewebapp.util.ControllerUtil;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserdetailController", value = "/userdetail")
public class UserdetailController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();

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
        String name = request.getParameter("name");
        System.out.println(name);
        String surname= request.getParameter("surname");
        System.out.println(surname);

        User u = userDao.getById(id);
        u.setName(name);
        u.setSurname(surname);

        if (request.getParameter("action").equals("update")) {
            System.out.println("update");
            userDao.updateUser(u);
        } else if (request.getParameter("action").equals("delete")) {
            userDao.removeUser(id);
        }
        response.sendRedirect("users");
    }
}
