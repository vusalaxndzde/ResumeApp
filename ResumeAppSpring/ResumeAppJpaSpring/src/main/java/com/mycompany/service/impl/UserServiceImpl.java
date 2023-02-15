package com.mycompany.service.impl;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService1")
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier(value = "userDao1")
    private UserDaoInter userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> filter(String name, String surname, Integer nationalityId) {
        return userDao.filter(name, surname, nationalityId);
    }
    
    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userDao.removeUser(id);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public int addUser(User u) {
        return userDao.addUser(u);
    }

}
