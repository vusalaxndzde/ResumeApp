package com.mycompany.dao.inter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;


public abstract class AbstractDAO {
    
    public Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "12345";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
    
}
