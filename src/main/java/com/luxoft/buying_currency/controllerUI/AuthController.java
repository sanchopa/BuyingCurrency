package com.luxoft.buying_currency.controllerUI;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.Pair;
import com.luxoft.buying_currency.service.PairService;
import com.luxoft.buying_currency.service.auth.AuthService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Класс-контроллер для обслуживания страницы авторизации auth.jsp
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
@Controller
public class AuthController {
//	@Autowired
//	private AuthService authService;


    /**
     * Метод для отображения страницы авторизации
     *
     * @return Возвращает страницу auth.jsp
     */
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authForm() {
        return "auth";
    }

    /**
     * Метод получает данные при отправке формы входа с страницы auth.jsp и отдает данные главной странице
     *
     * @return Возвращает страницу currency_exchange.jsp
     */
    @RequestMapping(value = "/currency_exchange", method = RequestMethod.POST)
    public String authSubmit(@RequestParam String name, Model model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        AuthService authService = context.getBean(AuthService.class);
        Account account = authService.auth(name);
        model.addAttribute("name", name);
        model.addAttribute("balanceRUB", account.getBalanceRUB());
        model.addAttribute("balanceUSD", account.getBalanceUSD());
        model.addAttribute("balanceEUR", account.getBalanceEUR());

        PairService pairService = context.getBean(PairService.class);
        model.addAttribute("usdrub", pairService.getCoursePair("usdrub"));
        model.addAttribute("usdeur", pairService.getCoursePair("usdeur"));
        model.addAttribute("rubeur", pairService.getCoursePair("rubeur"));
        return "currency_exchange";
    }
}