package com.mycompany.controller;

import com.mycompany.entity.User;
import com.mycompany.form.UserForm;
import com.mycompany.service.inter.UserServiceInter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceInter userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView index(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "nationality", required = false) Integer nid) {
        List<User> users = userService.filter(name, surname, nid);
        ModelAndView mv = new ModelAndView("usersJ");
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(value = "/usersm", method = RequestMethod.GET)
    public ModelAndView indexM(@ModelAttribute("userFilter") UserForm userForm) {
        ModelAndView mv = new ModelAndView("usersM");
        List<User> usersList = userService.filter(userForm.getName(), userForm.getSurname(), userForm.getNationalityId());
        mv.addObject("users", usersList);
        return mv;
    }

    @GetMapping(value = "/filter")
    public ModelAndView filter(@Valid @ModelAttribute("userFilter") UserForm userForm, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("usersM");
        if (bindingResult.hasErrors()) {
            List<User> usersList = userService.filter(null, null, null);
            mv.addObject("users", usersList);
            return mv;
        }
        List<User> usersList = userService.filter(userForm.getName(), userForm.getSurname(), userForm.getNationalityId());
        mv.addObject("users", usersList);
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "* Your username or password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession session;
        SecurityContextHolder.clearContext();
        session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }
        return "redirect:/login?logout";
    }

//    @ModelAttribute("userFilter")
//    public UserForm getEmptyUserForm() {
//        return new UserForm("Vusal", "ax", null);
//    }

}
