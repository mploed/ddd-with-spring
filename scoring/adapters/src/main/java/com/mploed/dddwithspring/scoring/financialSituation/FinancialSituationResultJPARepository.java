package com.mploed.dddwithspring.scoring.financialSituation;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinancialSituationResultJPARepository implements FinancialSituationResultRepository {

	private FinancialSituationResultDAO dao;

	@Autowired
	public FinancialSituationResultJPARepository(FinancialSituationResultDAO dao) {
		this.dao = dao;
	}


	@Override
	public void save(FinancialSituationAggregate financialSituationAggregate) {
		FinancialSituationResultProjection projection = new FinancialSituationResultProjection();
		projection.setApplicationNumber(financialSituationAggregate.rootEntity.applicationNumber.toString());
		projection.setPoints(financialSituationAggregate.calculateScoringPoints());
	}

	@Override
	public FinancialSituationResultProjection retrieve(ApplicationNumber applicationNumber) {
		return dao.findByApplicationNumber(applicationNumber.toString());
	}

}
