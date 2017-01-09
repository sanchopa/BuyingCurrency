package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.User;

/**
 * Created by User on 04.01.2017.
 */
public interface BuyService {
    String buy(String currency1, String currency2, String sum, User user);
}
