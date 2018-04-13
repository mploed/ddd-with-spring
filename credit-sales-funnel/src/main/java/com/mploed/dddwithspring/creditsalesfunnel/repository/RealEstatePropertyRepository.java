package com.mploed.dddwithspring.creditsalesfunnel.repository;

import com.mploed.dddwithspring.creditsalesfunnel.model.realEstate.RealEstateProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstatePropertyRepository extends JpaRepository<RealEstateProperty, Long> {
	RealEstateProperty findByApplicationNumber(String applicationNumber);
}
