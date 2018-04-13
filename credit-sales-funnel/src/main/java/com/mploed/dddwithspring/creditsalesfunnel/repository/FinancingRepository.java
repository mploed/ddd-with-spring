package com.mploed.dddwithspring.creditsalesfunnel.repository;

import com.mploed.dddwithspring.creditsalesfunnel.model.financing.Financing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancingRepository extends JpaRepository<Financing, Long> {
	Financing findByApplicationNumber(String applicationNumber);
}
