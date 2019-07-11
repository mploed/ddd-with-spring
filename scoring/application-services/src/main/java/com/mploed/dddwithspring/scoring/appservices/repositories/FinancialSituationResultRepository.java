package com.mploed.dddwithspring.scoring.appservices.repositories;


import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;

public interface FinancialSituationResultRepository {
	void save(FinancialSituationAggregate financialSituationAggregate);

	FinancialSituationAggregate retrieve(ApplicationNumber applicationNumber);
}
