package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Skill> getAllSkill() {
        Query query = em.createQuery("select s from Skill s", Skill.class);
        return query.getResultList();
    }

    @Override
    public Skill getSkillById(int id) {
        return em.find(Skill.class, id);
    }

    @Override
    public boolean updateSkill(Skill s) {
        em.merge(s);
        return true;
    }

    @Override
    public int addSkill(Skill s) {
        em.persist(s);
        return s.getId();
    }

    @Override
    public boolean removeSkill(int id) {
        Skill s = em.find(Skill.class, id);
        em.remove(s);
        return true;
    }

}
