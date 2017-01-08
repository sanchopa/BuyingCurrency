package com.luxoft.buying_currency.controllerUI;

import com.luxoft.buying_currency.model.History;
import com.luxoft.buying_currency.model.User;
import com.luxoft.buying_currency.service.HistoryService;
import com.luxoft.buying_currency.service.PairService;
import com.luxoft.buying_currency.service.AuthService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Класс-контроллер для обслуживания страницы авторизации auth.jsp
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
@Controller
@SessionAttributes(types = User.class)
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
        User user = authService.auth(name);
        model.addAttribute(user);
        model.addAttribute("name", name);
        model.addAttribute("balanceRUB", user.getAccount().getBalanceRUB());
        model.addAttribute("balanceUSD", user.getAccount().getBalanceUSD());
        model.addAttribute("balanceEUR", user.getAccount().getBalanceEUR());

        PairService pairService = context.getBean(PairService.class);
        model.addAttribute("usdrub", pairService.getPair("usdrub").getCourse());
        model.addAttribute("eurrub", pairService.getPair("eurrub").getCourse());
        model.addAttribute("eurusd", pairService.getPair("eurusd").getCourse());

        HistoryService historyService = context.getBean(HistoryService.class);
        History history = user.getHistory();
        model.addAttribute("history",  historyService.getHistory(history));
        return "currency_exchange";
    }
}