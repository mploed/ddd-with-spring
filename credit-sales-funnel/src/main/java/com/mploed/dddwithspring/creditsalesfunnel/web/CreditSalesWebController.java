package com.mploed.dddwithspring.creditsalesfunnel.web;

import com.mploed.dddwithspring.creditsalesfunnel.event.CreditApplicationSubmittedEvent;
import com.mploed.dddwithspring.creditsalesfunnel.event.CreditSalesFunnelChannels;
import com.mploed.dddwithspring.creditsalesfunnel.model.CreditApplicationForm;
import com.mploed.dddwithspring.creditsalesfunnel.model.applicant.Applicant;
import com.mploed.dddwithspring.creditsalesfunnel.model.financing.Financing;
import com.mploed.dddwithspring.creditsalesfunnel.model.household.Household;
import com.mploed.dddwithspring.creditsalesfunnel.model.realEstate.RealEstateProperty;
import com.mploed.dddwithspring.creditsalesfunnel.model.validation.ApplicationSubmissionGroup;
import com.mploed.dddwithspring.creditsalesfunnel.repository.ApplicantRepository;
import com.mploed.dddwithspring.creditsalesfunnel.repository.FinancingRepository;
import com.mploed.dddwithspring.creditsalesfunnel.repository.HouseholdRepository;
import com.mploed.dddwithspring.creditsalesfunnel.repository.RealEstatePropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.UUID;

@Controller
public class CreditSalesWebController {
	private final Logger LOGGER = LoggerFactory.getLogger(CreditSalesWebController.class);

	private ApplicantRepository applicantRepository;

	private FinancingRepository financingRepository;

	private HouseholdRepository householdRepository;

	private RealEstatePropertyRepository realEstatePropertyRepository;

	private CreditSalesFunnelChannels creditSalesFunnelChannels;

	private Validator validator;

	@Autowired
	public CreditSalesWebController(ApplicantRepository applicantRepository, FinancingRepository financingRepository, HouseholdRepository householdRepository, RealEstatePropertyRepository realEstatePropertyRepository, CreditSalesFunnelChannels creditSalesFunnelChannels, Validator validator) {
		this.applicantRepository = applicantRepository;
		this.financingRepository = financingRepository;
		this.householdRepository = householdRepository;
		this.realEstatePropertyRepository = realEstatePropertyRepository;
		this.creditSalesFunnelChannels = creditSalesFunnelChannels;
		this.validator = validator;
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

	@PostMapping(path = "/application/{applicationNumber}")
	public String submitApplication(@PathVariable String applicationNumber) {
		Applicant firstApplicant = applicantRepository.findByApplicationNumberAndApplicantNumber(applicationNumber, "1");
		boolean firstApplicantValid = isValid(firstApplicant);

		boolean secondApplicantValid = true;
		Applicant secondApplicant = applicantRepository.findByApplicationNumberAndApplicantNumber(applicationNumber, "2");
		if(secondApplicant != null) {
			secondApplicantValid = isValid(secondApplicant);

		}

		Household household = householdRepository.findByApplicationNumber(applicationNumber);
		boolean householdValid = isValid(household);

		Financing financing = financingRepository.findByApplicationNumber(applicationNumber);
		boolean financingValid = isValid(financing);

		RealEstateProperty realEstateProperty = realEstatePropertyRepository.findByApplicationNumber(applicationNumber);
		boolean realEstatePropertyValid = isValid(realEstateProperty);

		boolean applicationValid = firstApplicantValid && secondApplicantValid && householdValid && financingValid && realEstatePropertyValid;
		if(applicationValid) {
			CreditApplicationSubmittedEvent event = new CreditApplicationSubmittedEvent();
			event.setApplicationNumber(applicationNumber);
			event.setFirstApplicant(firstApplicant);
			event.setSecondApplicant(secondApplicant);
			event.setFinancing(financing);
			event.setHousehold(household);
			event.setRealEstateProperty(realEstateProperty);

			creditSalesFunnelChannels.creditApplicationSubmittedOut().send(MessageBuilder.withPayload(event).build());
		}

		return "redirect:/";
	}

	@GetMapping(path = "/application/{applicationNumber}")
	public String applicationOverview(Model model, @PathVariable String applicationNumber) {

		Applicant firstApplicant = applicantRepository.findByApplicationNumberAndApplicantNumber(applicationNumber, "1");
		boolean firstApplicantValid = isValid(firstApplicant);

		Applicant secondApplicant = applicantRepository.findByApplicationNumberAndApplicantNumber(applicationNumber, "2");
		boolean secondApplicantValid = isValid(secondApplicant);

		Household household = householdRepository.findByApplicationNumber(applicationNumber);
		boolean householdValid = isValid(household);

		Financing financing = financingRepository.findByApplicationNumber(applicationNumber);
		boolean financingValid = isValid(financing);

		RealEstateProperty realEstateProperty = realEstatePropertyRepository.findByApplicationNumber(applicationNumber);
		boolean realEstatePropertyValid = isValid(realEstateProperty);


		boolean readyForSubmission = isApplicationReadyForSubmission(firstApplicantValid, secondApplicant, secondApplicantValid, householdValid, financingValid, realEstatePropertyValid);
		model.addAttribute("firstApplicant", firstApplicant);
		model.addAttribute("secondApplicant", secondApplicant);
		model.addAttribute("financing", financing);
		model.addAttribute("household", household);
		model.addAttribute("realEstateProperty", realEstateProperty);
		model.addAttribute("firstApplicantValid", firstApplicantValid );
		model.addAttribute("secondApplicantValid", secondApplicantValid );
		model.addAttribute("financingValid", financingValid );
		model.addAttribute("householdValid", householdValid );
		model.addAttribute("realEstatePropertyValid", realEstatePropertyValid );

		model.addAttribute("readForSubmission", readyForSubmission);
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

	private boolean isValid(Object entity) {
		boolean entityValid = false;
		if(entity != null) {
			Set constraintViolations = validator.validate(entity, ApplicationSubmissionGroup.class);
			entityValid = constraintViolations.isEmpty();
		}
		return entityValid;
	}

	private boolean isApplicationReadyForSubmission(boolean firstApplicantValid, Applicant secondApplicant, boolean secondApplicantValid, boolean householdValid, boolean financingValid, boolean realEstatePropertyValid) {
		boolean readyForSubmission = false;
		if(secondApplicant != null ) {
			readyForSubmission = firstApplicantValid &&
					secondApplicantValid &&
					financingValid &&
					realEstatePropertyValid &&
					householdValid;
		} else {
			readyForSubmission = firstApplicantValid &&
					financingValid &&
					realEstatePropertyValid &&
					householdValid;
		}
		return readyForSubmission;
	}

}
