package com.mycompany.dao.inter;

import com.mycompany.entity.User;
import java.util.List;

public interface UserDaoInter {
    
    public List<User> getAll();
    
    public User getById(int id);
    
    public int addUser(User u);
    
    public boolean updateUser(User u);
    
    public boolean removeUser(int id);
    
}
