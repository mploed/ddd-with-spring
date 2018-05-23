package com.mploed.dddwithspring.creditagency.service;

import com.mploed.dddwithspring.creditagency.model.PersonRating;
import com.mploed.dddwithspring.creditagency.repository.PersonRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class PersonRatingQueryService {
	private PersonRatingRepository personRatingRepository;

	@Autowired
	public PersonRatingQueryService(PersonRatingRepository personRatingRepository) {
		this.personRatingRepository = personRatingRepository;
	}

	public void ratePerson(String firstName, String lastName, String street, String postCode, String city) {
		PersonRating rating = new PersonRating();
		rating.setCity(city);
		rating.setFirstName(firstName);
		rating.setLastName(lastName);
		rating.setPostCode(postCode);
		rating.setStreet(street);
		rating.setPoints(100);
		rating.setLastUpdated(new Date());
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.add(Calendar.MONTH, 1);
		System.out.println(gregorianCalendar.getTime());
		rating.setValidTo(gregorianCalendar.getTime());
		personRatingRepository.save(rating);
	}
}
