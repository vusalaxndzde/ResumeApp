package com.mycompany.controller;

import com.mycompany.entity.User;
import com.mycompany.form.UserForm;
import com.mycompany.service.inter.UserServiceInter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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


//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String nationalityIdStr = request.getParameter("nationality");
//        Integer nationalityId = null;
//        if (nationalityIdStr != null && !nationalityIdStr.trim().equals("")) {
//            nationalityId = Integer.valueOf(nationalityIdStr);
//        }
//        List<User> users = userService.filter(name, surname, nationalityId);
//        request.setAttribute("users", users);
//        return "users";
//    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
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
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

//    @ModelAttribute("userFilter")
//    public UserForm getEmptyUserForm() {
//        return new UserForm("Vusal", "ax", null);
//    }

}
