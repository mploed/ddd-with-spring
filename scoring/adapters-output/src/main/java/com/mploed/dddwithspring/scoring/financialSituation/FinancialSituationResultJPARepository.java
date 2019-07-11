package com.mploed.dddwithspring.scoring.financialSituation;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.Money;
import com.mploed.dddwithspring.scoring.appservices.repositories.FinancialSituationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
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
		projection.setIncomingOther(financialSituationAggregate.rootEntity.incomings.otherIncome.getAmount());
		projection.setIncomingSalary(financialSituationAggregate.rootEntity.incomings.salary.getAmount());
		projection.setOutgoingCostOfLiving(financialSituationAggregate.rootEntity.outgoings.costOfLiving.getAmount());
		projection.setOutgoingRent(financialSituationAggregate.rootEntity.outgoings.rent.getAmount());
		dao.save(projection);
	}

	@Override
	public FinancialSituationAggregate retrieve(ApplicationNumber applicationNumber) {
		FinancialSituationResultProjection projection = dao.findByApplicationNumber(applicationNumber.toString());
		if(projection != null) {
			return new FinancialSituationAggregate.FinancialSituationBuilder(new ApplicationNumber(projection.getApplicationNumber()))
					.costOfLiving(new Money(projection.getOutgoingCostOfLiving()))
					.otherIncome(new Money(projection.getIncomingOther()))
					.rent(new Money(projection.getOutgoingRent()))
					.salary(new Money(projection.getIncomingSalary()))
					.build();
		} else {
			return null;
		}

	}

}
