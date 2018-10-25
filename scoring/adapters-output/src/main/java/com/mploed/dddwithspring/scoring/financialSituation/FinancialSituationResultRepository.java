package com.mploed.dddwithspring.scoring.financialSituation;


import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;

public interface FinancialSituationResultRepository {
	void save(FinancialSituationAggregate financialSituationAggregate);

	FinancialSituationResultProjection retrieve(ApplicationNumber applicationNumber);
}
