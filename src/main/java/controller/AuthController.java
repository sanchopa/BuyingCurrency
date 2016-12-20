package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String authForm() {
		return "auth";
	}

	@RequestMapping(value = "/currency_exchange", method = RequestMethod.POST)
	public String authSubmit(@RequestParam String login, @RequestParam String password, Model model) {
		model.addAttribute("login", login);
		System.out.println(password);
		return "currency_exchange";
	}
}