package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.Pair;

/**
 * Created by User on 03.01.2017.
 */
public interface PairDao {
    /** Метод добавляет объект Pair в БД
     */
    void add(Pair pair);

    /** Метод извлекает объект пользователя из БД по его имени
     * @return Возвращает объект User
     */
    Pair get(String name);

    String getCourse(String name);
}
