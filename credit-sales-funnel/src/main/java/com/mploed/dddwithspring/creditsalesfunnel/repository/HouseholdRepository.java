package com.mploed.dddwithspring.creditsalesfunnel.repository;

import com.mploed.dddwithspring.creditsalesfunnel.model.household.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
	Household findByApplicationNumber(String applicationNumber);
}
