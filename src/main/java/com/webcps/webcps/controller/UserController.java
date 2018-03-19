package com.webcps.webcps.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${spring.ipaddress}")
	private String ipaddress;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model, @RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		
		System.out.println("*********************************************"+ipaddress);
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

		Map<String, String> decoded = calculationService.getData(ticketNumber);
		String barcode_loc_code = decoded.get("loc_code_same");
		String barcode_in_time = decoded.get("in_time_barcode");
		String barcode_tiTickeNo = decoded.get("tiTicketNo");
		String barcode_gateId = decoded.get("gateId");

		if ("false".equals(barcode_loc_code)) {
			model.addAttribute("locCodeDiff", "Location code different than expected");
		} else {
			TrTfTransfast trTfTransfast = trTfTransfastRepo.findOne(ticketNumber);
			if (trTfTransfast != null) {
				model.addAttribute("alreadyScanned", "Ticket already scanned");
			} else {
				BigDecimal rate = calculationService.calacRateInfo(ticketNumber, barcode_in_time, barcode_tiTickeNo,
						barcode_gateId);
				if (rate.compareTo(new BigDecimal(-9999)) != 0)
					model.addAttribute("success", "Transaction Process completed successfully");
				else
					model.addAttribute("error", "Transaction Process Failed");
			}

		}

		return "welcome";
	}

	@RequestMapping(value = "/calc", method = RequestMethod.GET)
	public BigDecimal getCalculation(@RequestParam("barcode") String barcode) {

		Map<String, String> decoded = calculationService.getData(barcode);
		String barcode_loc_code = decoded.get("loc_code_same");
		String barcode_in_time = decoded.get("in_time_barcode");
		String barcode_tiTickeNo = decoded.get("tiTicketNo");
		String barcode_gateId = decoded.get("gateId");

		return calculationService.calacRateInfo(barcode, barcode_in_time, barcode_tiTickeNo, barcode_gateId);
	}
}
