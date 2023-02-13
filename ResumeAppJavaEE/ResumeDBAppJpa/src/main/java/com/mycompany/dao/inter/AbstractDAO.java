package com.mycompany.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class AbstractDAO {
    
    public Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "12345";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
    
    private static EntityManagerFactory emf = null;
    
    public EntityManager createEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("resumedbappPU");
        }
        return emf.createEntityManager();
    }
    
    public static void closeEmf() {
        emf.close();
        emf = null;
    }
    
}
