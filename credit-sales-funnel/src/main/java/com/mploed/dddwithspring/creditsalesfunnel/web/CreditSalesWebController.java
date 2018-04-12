package com.mploed.dddwithspring.creditsalesfunnel.web;

import com.mploed.dddwithspring.creditsalesfunnel.model.CreditApplicationForm;
import com.mploed.dddwithspring.creditsalesfunnel.model.applicant.Applicant;
import com.mploed.dddwithspring.creditsalesfunnel.model.household.Household;
import com.mploed.dddwithspring.creditsalesfunnel.model.realEstate.RealEstateProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CreditSalesWebController {
	private final Logger LOGGER = LoggerFactory.getLogger(CreditSalesWebController.class);


	@GetMapping(path = "/")
	public String index() {
		return "index";
	}
	@PostMapping(path = "/")
	public String createApplicationNumber(Model model) {
		String applicationNumber = UUID.randomUUID().toString();
		model.addAttribute("applicationNumber", applicationNumber);
		return "applicationOverview";
	}


	@GetMapping(path = "/application/{applicationNumber}/applicant/{applicantNumber}")
	public String applicant(Model model, @PathVariable String applicationNumber, @PathVariable String applicantNumber) {


		model.addAttribute("applicant", new Applicant(applicationNumber, applicantNumber));
		model.addAttribute("applicantNumber", applicantNumber);
		model.addAttribute("applicationNumber", applicationNumber);
		return "applicant";
	}

	@GetMapping(path = "/application/{applicationNumber}/household")
	public String household(Model model, @PathVariable String applicationNumber) {
		model.addAttribute("household", new Household(applicationNumber));
		return "household";
	}

	@GetMapping(path = "/application/{applicationNumber}/realEstateProperty")
	public String realEstateProperty(Model model, @PathVariable String applicationNumber) {
		model.addAttribute("realEstateProperty", new RealEstateProperty(applicationNumber));
		return "realEstateProperty";
	}



}
