package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс который предаставляет сервисы по авторизации пользователя в системе
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    PropertiesService propService;
    @Autowired
    UserService userService;

    private static final Logger log = Logger.getLogger(AuthServiceImpl.class);

    /**
     * Метод авторизации
     */
    public User auth(String name) {
        User user = userService.getUser(name);
        if (user == null) {
            User newUser = new User();
            newUser.setName(name);
            newUser.setBalanceRUB(propService.getDefaultBalanceRUB());
            newUser.setBalanceUSD(propService.getDefaultBalanceUSD());
            newUser.setBalanceEUR(propService.getDefaultBalanceEUR());
            userService.addUser(newUser);
            log.info("Создан новый пользователь");
        }
        return user;
    }
}