package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.user.User;

/**
 * Created by Alex Zavalnyi on 21.12.2016.
 */
public interface UserDao {
    void add(User user);
    User get(String name);
}
