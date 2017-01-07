package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.History;
import com.luxoft.buying_currency.model.Pair;
import com.luxoft.buying_currency.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Класс который предаставляет сервисы по авторизации пользователя в системе
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
@Service("authService")
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
            User newUser = new User(name);
            Account account = new Account(newUser, propService.getDefaultBalanceRUB(),
                    propService.getDefaultBalanceUSD(), propService.getDefaultBalanceEUR());
            newUser.setAccount(account);
            History history = new History(newUser);
            newUser.setHistory(history);
            userService.addUser(newUser);
            log.info("Создан новый пользователь");

            return newUser;
        }
        return user;
    }
}