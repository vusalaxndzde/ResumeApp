package com.mycompany.controller;

import com.mycompany.dao.impl.UserRepository;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserDetailController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CountryDaoInter countryDao;

    @Autowired
    private EmploymentHistoryDaoInter empDao;

    @Autowired
    private UserSkillDaoInter userSkillDao;

    @RequestMapping(value = "/userdetail", method = RequestMethod.GET)
    public String userDetail(Model model, @RequestParam(value = "id") int id) {
        User user = userRepo.getById(id);
        List<Country> countries = countryDao.getAllCountry();
        List<EmploymentHistory> userEmpHistories = empDao.getEmploymentHistoryByUserId(user.getId());
        List<UserSkill> userSkills = userSkillDao.getAllUserSkillByUserId(user.getId());
        
        model.addAttribute("user", user);
        return "userdetail";
    }

}
