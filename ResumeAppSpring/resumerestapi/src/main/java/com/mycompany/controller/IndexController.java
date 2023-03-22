package com.mycompany.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/userinfo")
    public ModelAndView userInfo(ModelAndView modelAndView, @AuthenticationPrincipal OAuth2User user) {
        modelAndView.setViewName("userinfo");
        modelAndView.addObject("name", user.getAttribute("name"));
        modelAndView.addObject("email", user.getAttribute("email"));
        return modelAndView;
    }

}
