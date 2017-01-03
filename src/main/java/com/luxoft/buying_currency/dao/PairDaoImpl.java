package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.Pair;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by User on 03.01.2017.
 */

@Repository
public class PairDaoImpl implements PairDao {

    private static final Logger log = Logger.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Pair pair) {
        em.persist(pair);
    }

    @Override
    public Pair get(String name) {
        Pair newPair;
        try {
            newPair = em.createQuery("FROM pair p WHERE p.name=:name", Pair.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            newPair = null;
        }
        return newPair;
    }

    @Override
    public String getCourse(String name) {
        return (String) em.createQuery("SELECT p.course FROM pair p WHERE p.name=:name").setParameter("name", name).getSingleResult();
    }
}

