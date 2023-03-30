package com.mycompany.controller;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Authentication authentication, HttpSession session) {
        String email = authentication.getName();
        User loggedInUser = userRepo.getUserByEmail(email);
        session.setAttribute("loggedInUser", loggedInUser);
        return "index";
    }

}
