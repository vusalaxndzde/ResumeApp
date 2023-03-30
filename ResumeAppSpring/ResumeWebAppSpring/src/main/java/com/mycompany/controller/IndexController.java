package com.mycompany.controller;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Authentication authentication) {
        String email = authentication.getName();
        User loggedInUser = userRepo.getUserByEmail(email);
        model.addAttribute("loggedInUser", loggedInUser);
        return "index";
    }

}
