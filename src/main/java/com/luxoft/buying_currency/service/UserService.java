package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;

/**
 * Created by Alex Zavalnyi on 21.12.2016.
 */

public interface UserService {
    void addUser(User user);
    User getUser(String name);
    void saveUser(User user);
}
