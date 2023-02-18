package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        Query query = em.createQuery("select us from UserSkill us where us.user = :user", UserSkill.class);
        query.setParameter("user", new User(userId));
        return query.getResultList();
    }

    @Override
    public int addUserSkill(UserSkill us) {
        em.persist(us);
        return us.getId();
    }

    @Override
    public boolean removeUserSkill(int id) {
        UserSkill us = em.find(UserSkill.class, id);
        em.remove(us);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        em.merge(us);
        return true;
    }

}
