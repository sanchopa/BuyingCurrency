package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.user.User;

/**
 * Created by User on 28.12.2016.
 */
public interface AuthService {
    User auth(String name);
}
