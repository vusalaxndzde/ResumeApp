package com.company.resumewebapp;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserController", value = "/userdetail")
public class UserController extends HttpServlet {

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
            request.setAttribute("owner", true);
            request.setAttribute("u", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?msg=" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname= request.getParameter("surname");

        User u = userDao.getById(id);
        u.setName(name);
        u.setSurname(surname);

        userDao.updateUser(u);

        response.sendRedirect("userdetail?id=" + id);
    }
}
