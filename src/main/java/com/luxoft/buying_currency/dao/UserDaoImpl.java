package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Класс работы с таблице Users в базе данных
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger log = Logger.getLogger(UserDaoImpl.class);

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
            newUser = em.createQuery("FROM users u WHERE u.name=:name", User.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            newUser = null;
        }
        return newUser;
    }

    @Override
    public void save(User user) {
        em.merge(user);
    }
}
