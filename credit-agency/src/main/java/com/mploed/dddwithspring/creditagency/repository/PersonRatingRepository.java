package com.mploed.dddwithspring.creditagency.repository;

import com.mploed.dddwithspring.creditagency.model.PersonRating;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;


public interface PersonRatingRepository extends JpaRepository<PersonRating, Long> {
	@Query("SELECT max(pr.lastUpdated) FROM PersonRating pr")
	Date lastUpdate();

}
