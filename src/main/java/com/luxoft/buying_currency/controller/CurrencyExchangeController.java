package com.luxoft.buying_currency.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Класс-контроллер для обслуживания главной страницы currency_exchange.jsp
 * @autor Zavalny Alexander
 * @version 1.0
 */

@Controller
public class CurrencyExchangeController {

    private static final Logger log = Logger.getLogger(CurrencyExchangeController.class);

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        log.info("logout");
        return "auth";
    }

}
