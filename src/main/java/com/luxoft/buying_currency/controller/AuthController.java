package com.luxoft.buying_currency.controller;

import com.luxoft.buying_currency.service.AuthService;
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
	public String authSubmit(@RequestParam String name, Model model) {
		AuthService.auth(name);
		model.addAttribute("name", name);
		return "currency_exchange";
	}
}