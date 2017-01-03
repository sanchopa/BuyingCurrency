package com.luxoft.buying_currency.dao;

import com.luxoft.buying_currency.model.User;

/** Интерфейс работы с таблице Users в базе данных
 * @autor Zavalny Alexander
 * @version 1.0
 */
public interface UserDao {
    /** Метод добавляет объект User в БД
     */
    void add(User user);

    /** Метод извлекает объект пользователя из БД по его имени
     * @return Возвращает объект User
     */
    User get(String name);
}
