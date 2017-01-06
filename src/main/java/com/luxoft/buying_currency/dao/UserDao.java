package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;

/**
 * Интерфейс работы с таблице Users в базе данных
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
public interface UserDao {
    /**
     * Метод добавляет объект User в БД
     */
    void add(User user);

    /**
     * Метод извлекает объект пользователя из БД по его имени
     *
     * @return Возвращает объект User
     */
    User get(String name);

    void saveAccount (Account account);
}
