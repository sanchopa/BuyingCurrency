package com.luxoft.buying_currency.controller;

import com.luxoft.buying_currency.service.AuthService;
import com.luxoft.buying_currency.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** Класс-контроллер для обслуживания страницы авторизации auth.jsp
 * @autor Zavalny Alexander
 * @version 1.0
 */
@Controller
public class AuthController {
//	@Autowired
//	private AuthService authService;


	/** Метод для отображения страницы авторизации
	 * @return Возвращает страницу auth.jsp
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String authForm() {
		return "auth";
	}

	/** Метод получает данные при отправке формы входа с страницы auth.jsp
	 * @return Возвращает страницу currency_exchange.jsp
	 */
	@RequestMapping(value = "/currency_exchange", method = RequestMethod.POST)
	public String authSubmit(@RequestParam String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
		AuthService authService =  context.getBean(AuthService.class);
		authService.auth(name);
		model.addAttribute("name", name);
		return "currency_exchange";
	}
}