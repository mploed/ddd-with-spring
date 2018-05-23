package com.mploed.dddwithspring.creditagency.web;

import com.mploed.dddwithspring.creditagency.repository.PersonRatingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("person-rating")
public class PersonRatingController {
	private PersonRatingRepository personRatingRepository;

	public PersonRatingController(PersonRatingRepository personRatingRepository) {
		this.personRatingRepository = personRatingRepository;
	}

	@RequestMapping(value = "/feed", produces = "application/atom+xml")
	public ModelAndView orderFeed(WebRequest webRequest) {
		Sort sort = new Sort(Sort.Direction.DESC, "lastUpdated");
		return new ModelAndView(new PersonRatingAtomFeedView(personRatingRepository), "personRatings", personRatingRepository.findAll(sort));
	}
}
