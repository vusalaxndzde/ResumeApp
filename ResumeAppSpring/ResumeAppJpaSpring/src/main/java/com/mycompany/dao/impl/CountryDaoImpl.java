package com.mycompany.dao.impl;

import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CountryDaoImpl implements CountryDaoInter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Country> getAllCountry() {
        Query query = em.createQuery("select c from Country c", Country.class);
        return query.getResultList();
    }

    @Override
    public Country getCountryById(int id) {
        return em.find(Country.class, id);
    }

    @Override
    public Country getCountryByName(String name) {
        Query query = em.createQuery("select c from Country c where c.name = :name");
        query.setParameter("name", name);
        return (Country) query.getSingleResult();
    }

    @Override
    public Country getCountryByNationality(String nationality) {
        Query query = em.createQuery("select c from Country c where c.nationality = :nationality");
        query.setParameter("nationality", nationality);
        return (Country) query.getSingleResult();
    }

    @Override
    public boolean updateCountry(Country c) {
        em.merge(c);
        return true;
    }

    @Override
    public int addCountry(Country c) {
        em.persist(c);
        return c.getId();
    }

    @Override
    public boolean removeCountry(int id) {
        Country c = em.find(Country.class, id);
        em.remove(c);
        return true;
    }

}
