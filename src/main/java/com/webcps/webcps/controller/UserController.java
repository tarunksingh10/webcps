package com.webcps.webcps.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webcps.webcps.model.TrTfTransfast;
import com.webcps.webcps.repository.TrTfTransfastRepo;
import com.webcps.webcps.service.CalculationService;
import com.webcps.webcps.service.LoginService;

@Controller
public class UserController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private TrTfTransfastRepo trTfTransfastRepo;

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
	public String endShift(@RequestParam("userName") String userName) {
		loginService.endShift(userName);
		return "login";
	}

	@RequestMapping(value = "/cpsOperation", method = RequestMethod.POST)
	public String cpsOperation(Model model, @RequestParam("ticketNumber") String ticketNumber) {

		TrTfTransfast trTfTransfast = trTfTransfastRepo.findOne(ticketNumber);
		if (trTfTransfast != null) {
			model.addAttribute("alreadyScanned", "Ticket already scanned");
		} else {
			BigDecimal rate = calculationService.calacRateInfo(ticketNumber);
			if (rate.compareTo(new BigDecimal(-9999)) != 0)
				model.addAttribute("success", "Transaction Process completed successfully");
			else
				model.addAttribute("error", "Transaction Process Failed");
		}

		return "welcome";
	}

	@RequestMapping(value = "/calc", method = RequestMethod.GET)
	public BigDecimal getCalculation(@RequestParam("barcode") String barcode) {
		return calculationService.calacRateInfo(barcode);
	}
}
