package com.luxoft.buying_currency.controllerUI;

import com.luxoft.buying_currency.model.User;
import com.luxoft.buying_currency.service.BuyService;
import com.luxoft.buying_currency.service.HistoryService;
import com.luxoft.buying_currency.service.PairService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Класс-контроллер для обслуживания главной страницы currency_exchange.jsp
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */

@Controller
@SessionAttributes(types = User.class)
public class CurrencyExchangeController {

    private static final Logger log = Logger.getLogger(CurrencyExchangeController.class);

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        log.info("logout");
        return "auth";
    }

    @RequestMapping(value = "buy", method = RequestMethod.POST)
    public String buy(@RequestParam int currency1, int currency2, String sum, Model model, User user) {
        log.info("buy");
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        BuyService buyService = context.getBean(BuyService.class);
        buyService.buy(currency1, currency2, sum, user);

        //model.addAttribute(user);
        model.addAttribute("name", user.getName());
        model.addAttribute("balanceRUB", user.getAccount().getBalanceRUB());
        model.addAttribute("balanceUSD", user.getAccount().getBalanceUSD());
        model.addAttribute("balanceEUR", user.getAccount().getBalanceEUR());

        PairService pairService = context.getBean(PairService.class);
        model.addAttribute("usdrub", pairService.getPair("usdrub").getCourse());
        model.addAttribute("eurrub", pairService.getPair("eurrub").getCourse());
        model.addAttribute("eurusd", pairService.getPair("eurusd").getCourse());

        HistoryService historyService = context.getBean(HistoryService.class);
        model.addAttribute("history",  historyService.getHistory(user.getHistory()));

        return "currency_exchange";
    }
}
