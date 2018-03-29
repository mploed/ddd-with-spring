package com.mploed.dddwithspring.scoring.financialSituation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialSituationResultDAO extends JpaRepository<FinancialSituationResultProjection, Long> {
	FinancialSituationResultProjection findByApplicationNumber(String applicationNumber);
}
