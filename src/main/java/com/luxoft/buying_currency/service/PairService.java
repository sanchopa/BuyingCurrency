package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.Pair;

/**
 * Created by User on 03.01.2017.
 */
public interface PairService {
    void addPair(Pair pair);

    Pair getPair(String name);

    double generateRandomDecimal();

    void generateRandomCursePair(String namePair);

    void savePair(Pair pair);

    void generateRandomPair(int millisecond);
}
