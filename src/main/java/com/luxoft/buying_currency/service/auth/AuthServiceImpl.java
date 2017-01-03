package com.luxoft.buying_currency.service.auth;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;
import com.luxoft.buying_currency.service.PropertiesService;
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
    public Account auth(String name) {
        Account account;
        User user = userService.getUser(name);
        if (user == null) {
            User newUser = new User(name);
            account = new Account(newUser, propService.getDefaultBalanceRUB(),
                                            propService.getDefaultBalanceUSD(), propService.getDefaultBalanceEUR());
            newUser.setAccount(account);
            userService.addUser(newUser);
            log.info("Создан новый пользователь");
        } else {
            account = user.getAccount();
        }
        return account;
    }
}