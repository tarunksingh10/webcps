package com.webcps.webcps.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webcps.webcps.model.CpsOperationReq;
import com.webcps.webcps.model.Login;
import com.webcps.webcps.model.TrTfTransfast;
import com.webcps.webcps.repository.TrTfTransfastRepo;
import com.webcps.webcps.service.CalculationService;
import com.webcps.webcps.service.LoginService;

@Controller
@Scope("session")
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

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String welcome(Model model, @ModelAttribute("login") Login login, HttpServletRequest request) {

		System.out.println("*********************************************" + ipaddress);
		String userExists = loginService.userAuthentication(login.getUserName(), login.getPassword());
		if (userExists != null) {
			model.addAttribute("errorMessage", userExists);
			return "login";
		}
		loginService.afterLogin(login.getUserName());
		model.addAttribute("userName", login.getUserName());
		HttpSession session = request.getSession();
		session.setAttribute("userName", login.getUserName());
		return "welcome";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(@RequestParam("userName") String userName, HttpServletRequest request) {
		loginService.logout(userName);
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping(value = "/endShift", method = RequestMethod.POST)
	public String endShift(@RequestParam("userName") String userName, HttpServletRequest request) {
		loginService.endShift(userName);
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping(value = "/cpsOperation", method = RequestMethod.POST)
	public String cpsOperation(Model model, @ModelAttribute("cpsOperation") CpsOperationReq cpsOperationreq) {

		Map<String, String> decoded = calculationService.getData(cpsOperationreq.getTicketNumber());
		String barcode_loc_code = decoded.get("loc_code_same");
		String barcode_in_time = decoded.get("in_time_barcode");
		String barcode_tiTickeNo = decoded.get("tiTicketNo");
		String barcode_gateId = decoded.get("gateId");

		if ("false".equals(barcode_loc_code)) {
			model.addAttribute("locCodeDiff", "Location code different than expected");
		} else {
			TrTfTransfast trTfTransfast = trTfTransfastRepo.findOne(cpsOperationreq.getTicketNumber());
			if (trTfTransfast != null) {
				model.addAttribute("alreadyScanned", "Ticket already scanned");
			} else {
				BigDecimal rate = calculationService.calacRateInfo(cpsOperationreq.getUserName(),
						cpsOperationreq.getTicketNumber(), barcode_in_time, barcode_tiTickeNo, barcode_gateId);
				if (rate.compareTo(new BigDecimal(-9999)) != 0)
					model.addAttribute("success", "Transaction Process completed successfully");
				else
					model.addAttribute("error", "Transaction Process Failed");
			}

		}

		return "welcome";
	}

}
