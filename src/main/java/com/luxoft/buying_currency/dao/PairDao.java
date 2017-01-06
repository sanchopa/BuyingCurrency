package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.Pair;

/**
 * Created by Alex Zavalnyi on 03.01.2017.
 */
public interface PairDao {
    /**
     * Метод добавляет объект Pair в БД
     */
    void add(Pair pair);

    /**
     * Метод извлекает объект пары валют из БД по его имени
     *
     * @return Возвращает объект User
     */
    Pair get(String name);
}
