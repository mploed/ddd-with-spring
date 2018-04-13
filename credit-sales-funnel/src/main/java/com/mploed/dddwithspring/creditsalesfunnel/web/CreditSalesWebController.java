package com.mploed.dddwithspring.creditsalesfunnel.web;

import com.mploed.dddwithspring.creditsalesfunnel.model.CreditApplicationForm;
import com.mploed.dddwithspring.creditsalesfunnel.model.applicant.Applicant;
import com.mploed.dddwithspring.creditsalesfunnel.model.financing.Financing;
import com.mploed.dddwithspring.creditsalesfunnel.model.household.Household;
import com.mploed.dddwithspring.creditsalesfunnel.model.realEstate.RealEstateProperty;
import com.mploed.dddwithspring.creditsalesfunnel.repository.ApplicantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class CreditSalesWebController {
	private final Logger LOGGER = LoggerFactory.getLogger(CreditSalesWebController.class);

	private ApplicantRepository applicantRepository;

	@Autowired
	public CreditSalesWebController(ApplicantRepository applicantRepository) {
		this.applicantRepository = applicantRepository;
	}

	@GetMapping(path = "/")
	public String index() {
		return "index";
	}

	@PostMapping(path = "/")
	public RedirectView createApplicationNumber() {
		String applicationNumber = UUID.randomUUID().toString();
		return new RedirectView("/application/"+applicationNumber);
	}


	@GetMapping(path = "/application/{applicationNumber}")
	public String applicationOverview(Model model, @PathVariable String applicationNumber) {

		model.addAttribute("applicationNumber", applicationNumber);
		return "applicationOverview";
	}


	@GetMapping(path = "/application/{applicationNumber}/applicant/{applicantNumber}")
	public String applicant(Model model, @PathVariable String applicationNumber, @PathVariable String applicantNumber) {
		Applicant applicant = applicantRepository.findByApplicationNumberAndApplicantNumber(applicationNumber, applicantNumber);
		if (applicant == null) {
			applicant = new Applicant(applicationNumber, applicantNumber);
		}
		model.addAttribute("applicant", applicant);
		return "applicant";
	}

	@PostMapping(path = "/application/{applicationNumber}/applicant/{applicantNumber}")
	public RedirectView saveApplicant(@ModelAttribute Applicant applicant, @PathVariable String applicationNumber, @PathVariable String applicantNumber) {
		applicantRepository.save(applicant);
		return new RedirectView("/application/" + applicationNumber);
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

	@GetMapping(path = "/application/{applicationNumber}/financing")
	public String financing(Model model, @PathVariable String applicationNumber) {
		model.addAttribute("financing", new Financing(applicationNumber));
		return "financing";
	}

}
