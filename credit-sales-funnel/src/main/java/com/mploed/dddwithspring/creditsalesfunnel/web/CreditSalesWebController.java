package com.mploed.dddwithspring.creditsalesfunnel.web;

import com.mploed.dddwithspring.creditsalesfunnel.model.CreditApplicationForm;
import com.mploed.dddwithspring.creditsalesfunnel.model.applicant.Applicant;
import com.mploed.dddwithspring.creditsalesfunnel.model.financing.Financing;
import com.mploed.dddwithspring.creditsalesfunnel.model.household.Household;
import com.mploed.dddwithspring.creditsalesfunnel.model.realEstate.RealEstateProperty;
import com.mploed.dddwithspring.creditsalesfunnel.repository.ApplicantRepository;
import com.mploed.dddwithspring.creditsalesfunnel.repository.FinancingRepository;
import com.mploed.dddwithspring.creditsalesfunnel.repository.HouseholdRepository;
import com.mploed.dddwithspring.creditsalesfunnel.repository.RealEstatePropertyRepository;
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

	private FinancingRepository financingRepository;

	private HouseholdRepository householdRepository;

	private RealEstatePropertyRepository realEstatePropertyRepository;

	@Autowired
	public CreditSalesWebController(ApplicantRepository applicantRepository, FinancingRepository financingRepository, HouseholdRepository householdRepository, RealEstatePropertyRepository realEstatePropertyRepository) {
		this.applicantRepository = applicantRepository;
		this.financingRepository = financingRepository;
		this.householdRepository = householdRepository;
		this.realEstatePropertyRepository = realEstatePropertyRepository;
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
		Household household = householdRepository.findByApplicationNumber(applicationNumber);
		if(household == null) {
			household = new Household(applicationNumber);
		}
		model.addAttribute("household", household);
		return "household";
	}

	@PostMapping(path = "/application/{applicationNumber}/household")
	public RedirectView saveHousehold(@ModelAttribute Household household, @PathVariable String applicationNumber) {
		householdRepository.save(household);
		return new RedirectView("/application/" + applicationNumber);
	}

	@GetMapping(path = "/application/{applicationNumber}/realEstateProperty")
	public String realEstateProperty(Model model, @PathVariable String applicationNumber) {
		RealEstateProperty realEstateProperty = realEstatePropertyRepository.findByApplicationNumber(applicationNumber);
		if(realEstateProperty == null) {
			realEstateProperty = new RealEstateProperty(applicationNumber);
		}
		model.addAttribute("realEstateProperty", realEstateProperty);
		return "realEstateProperty";
	}

	@PostMapping(path = "/application/{applicationNumber}/realEstateProperty")
	public RedirectView saveRealEstateProperty(@ModelAttribute RealEstateProperty realEstateProperty, @PathVariable String applicationNumber) {
		realEstatePropertyRepository.save(realEstateProperty);
		return new RedirectView("/application/" + applicationNumber);
	}

	@GetMapping(path = "/application/{applicationNumber}/financing")
	public String financing(Model model, @PathVariable String applicationNumber) {
		Financing financing = financingRepository.findByApplicationNumber(applicationNumber);
		if(financing == null) {
			financing = new Financing(applicationNumber);
		}
		model.addAttribute("financing", financing);
		return "financing";
	}

	@PostMapping(path = "/application/{applicationNumber}/financing")
	public RedirectView saveFinancing(@ModelAttribute Financing financing, @PathVariable String applicationNumber) {
		financingRepository.save(financing);
		return new RedirectView("/application/" + applicationNumber);
	}

}
