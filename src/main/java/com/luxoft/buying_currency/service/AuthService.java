package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.user.User;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Класс который предаставляет сервисы по авторизации пользователя в системе
 * @autor Zavalny Alexander
 * @version 1.0
 */
public class AuthService {

    private static final Logger log = Logger.getLogger(AuthService.class);

    /** Самы главный метод авторизации
     */
    public static void auth(String name) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/orm-context.xml");
        UserService service = (UserService) context.getBean("userService");
        if(service.getUser(name)==null) {
            User newUser = new User();
            newUser.setName(name);
            service.addUser(newUser);
            log.info("Создан новый пользователь");
        }
    }
}
