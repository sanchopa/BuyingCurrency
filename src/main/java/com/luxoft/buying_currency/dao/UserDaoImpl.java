package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by Alex Zavalnyi on 21.12.2016.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public User get(String name) {
        User newUser = null;
        try {
            newUser = em.createQuery("from users u where u.name=:name", User.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            newUser = null;
        }
        return newUser;
    }
}
