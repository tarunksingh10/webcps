package com.webcps.webcps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webcps.webcps.service.LoginService;

@Controller
public class UserController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model, @RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		String userExists = loginService.userAuthentication(userName, password);
		if (userExists != null) {
			model.addAttribute("errorMessage", userExists);
			return "login";
		}
		loginService.afterLogin(userName);
		model.addAttribute("userName", userName);
		return "welcome";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(@RequestParam("userName") String userName) {
		loginService.logout(userName);
		return "login";
	}

	@RequestMapping(value = "/endShift", method = RequestMethod.POST)
	public void endShift(@RequestParam("userName") String userName) {
		loginService.endShift(userName);
	}

	@RequestMapping(value = "/cpsOperation", method = RequestMethod.POST)
	public String cpsOperation(Model model, @RequestParam("ticketNumber") String ticketNumber) {
		model.addAttribute("success", "Transaction Process completed successfully");
		return "welcome";
	}
}
