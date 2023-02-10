package com.mycompany.dao.impl;

import com.mycompany.entity.User;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @Override
    public List<User> getAll() {
        EntityManager em = createEntityManager();
        Query query = em.createQuery("select u from User u", User.class);
        List<User> users = query.getResultList();
        closeEmf();
        return users;
    }

    @Override
    public List<User> filter(String name, String surname, Integer nationalityId) {
        EntityManager em = createEntityManager();
        String strQuery = "select u from User u where 1 = 1 ";

        if (name != null && !name.trim().equals("")) {
            strQuery += "and u.name = :name ";
        }
        if (surname != null && !surname.trim().equals("")) {
            strQuery += "and u.surname = :surname ";
        }
        if (nationalityId != null) {
            strQuery += "and u.nationality.id = :nationalityId ";
        }

        Query query = em.createQuery(strQuery, User.class);

        if (name != null && !name.trim().equals("")) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().equals("")) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nationalityId", nationalityId);
        }

        return query.getResultList();
    }

      // JPQL
//    @Override
//    public User getUserByEmail(String email) {
//        EntityManager em = createEntityManager();
//        Query query = em.createQuery("select u from User u where u.email = :email", User.class
//        );
//        query.setParameter("email", email);
//        List<User> user = query.getResultList();
//        if (user.size() == 1) {
//            return user.get(0);
//        }
//        return null;
//    }
    
    // CriteriaBuilder
//    @Override
//    public User getUserByEmail(String email) {
//        EntityManager em = createEntityManager();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> query = cb.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        CriteriaQuery<User> query1 = query.where(cb.equal(root.get("email"), email));
//        
//        Query q = em.createQuery(query1);
//        List<User> user = q.getResultList();
//        if (user.size() == 1) {
//            return user.get(0);
//        }
//        return null;
//    }
    
    // NamedQuery
//    @Override
//    public User getUserByEmail(String email) {
//        EntityManager em = createEntityManager();
//        Query query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//        List<User> user = query.getResultList();
//        if (user.size() == 1) {
//            return user.get(0);
//        }
//        return null;
//    }
    
    // Native SQL
    @Override
    public User getUserByEmail(String email) {
        EntityManager em = createEntityManager();
        Query query = em.createNativeQuery("select * from user where email = ?", User.class);
        query.setParameter(1, email);
        List<User> user = query.getResultList();
        if (user.size() == 1) {
            return user.get(0);
        }
        return null;
    }

    @Override
    public boolean updateUser(User u) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        closeEmf();
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        EntityManager em = createEntityManager();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        closeEmf();
        return true;
    }

    @Override
    public User getById(int id) {
        EntityManager em = createEntityManager();
        User u = em.find(User.class, id);
        closeEmf();
        return u;
    }

    @Override
    public int addUser(User u) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        closeEmf();
        return 1;
    }

}
