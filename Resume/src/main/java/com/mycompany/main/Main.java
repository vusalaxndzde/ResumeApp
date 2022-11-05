package com.mycompany.main;

import com.mycompany.bean.User;
import com.mycompany.dao.impl.UserDaoImpl;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter u = new UserDaoImpl();
        User a = u.getById(1);
        a.setName("Kerim");
        a.setEmail("kerim.resullu@gmail.com");
        u.updateUser(a);
        List<User> users = u.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
