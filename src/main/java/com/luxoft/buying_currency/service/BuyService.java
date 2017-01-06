package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.User;

/**
 * Created by User on 04.01.2017.
 */
public interface BuyService {
    void buy(int currency1, int currency2, String sum, User user);
}
