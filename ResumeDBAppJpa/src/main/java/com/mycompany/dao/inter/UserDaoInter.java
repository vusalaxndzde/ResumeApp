package com.mycompany.dao.inter;

import com.mycompany.entity.User;
import java.util.List;

public interface UserDaoInter {
    
    List<User> getAll();

    List<User> filter(String name, String surname, Integer nationalityId);

    User getUserByEmail(String email);
    
    User getById(int id);
    
    int addUser(User u);
    
    boolean updateUser(User u);
    
    boolean removeUser(int id);
    
}
