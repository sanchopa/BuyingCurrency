package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.dao.UserDao;
import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 21.12.2016.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    public void addUser(User user) {
        dao.add(user);
    }

    public User getUser(String name) {
        return dao.get(name);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        dao.save(user);
    }
}
