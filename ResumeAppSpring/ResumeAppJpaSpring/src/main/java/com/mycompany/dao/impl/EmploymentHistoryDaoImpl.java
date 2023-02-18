package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EmploymentHistory> getEmploymentHistoryByUserId(int userId) {
        Query query = em.createQuery("select eh from EmploymentHistory eh where eh.user = :user", EmploymentHistory.class);
        query.setParameter("user", new User(userId));
        return query.getResultList();
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
        em.merge(eh);
        return true;
    }

    @Override
    public int addEmploymentHistory(EmploymentHistory eh) {
        em.persist(eh);
        return eh.getId();
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        EmploymentHistory eh = em.find(EmploymentHistory.class, id);
        em.remove(eh);
        return true;
    }
    
}
