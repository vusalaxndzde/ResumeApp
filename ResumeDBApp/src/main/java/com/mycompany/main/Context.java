/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.dao.impl.UserDaoImpl;

/**
 *
 * @author Asus
 */
public class Context {
    
    public static UserDaoImpl instanceUserDao() {
        return new UserDaoImpl();
    }
    
}
