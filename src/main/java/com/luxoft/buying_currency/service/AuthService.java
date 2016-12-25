package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex Zavalnyi on 25.12.2016.
 */
public class AuthService {
    public static void auth(String name) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/orm-context.xml");
        UserService service = (UserService) context.getBean("userService");
        if(service.getUser(name)==null) {
            User newUser = new User();
            newUser.setName(name);
            service.addUser(newUser);
        }
    }
}
