package com.luxoft.buying_currency.service.auth;

import com.luxoft.buying_currency.model.Account;

/**
 * Created by User on 28.12.2016.
 */
public interface AuthService {
   Account auth(String name);
}
