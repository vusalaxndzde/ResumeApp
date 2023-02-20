package com.mycompany.controller;

import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInter userService;


    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String nationalityIdStr = request.getParameter("nationality");
        Integer nationalityId = null;
        if (nationalityIdStr != null && !nationalityIdStr.trim().equals("")) {
            nationalityId = Integer.valueOf(nationalityIdStr);
        }
        List<User> users = userService.filter(name, surname, nationalityId);
        request.setAttribute("users", users);
        return "usersJ";
    }


}
