package com.mploed.dddwithspring.scoring.scoringResult;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ScoringResultJPARepository implements ScoringResultRepository {
	private ScoringResultDAO scoringResultDAO;

	@Autowired
	public ScoringResultJPARepository(ScoringResultDAO scoringResultDAO) {
		this.scoringResultDAO = scoringResultDAO;
	}

	@Override
	public void save(ScoringResultAggregate scoringResultAggregate) {

		DetailedScoringResults detailedScoringResults = new DetailedScoringResults(scoringResultAggregate.rootEntity.scoringCalculationResults);

		ScoringResultEntity scoringResultEntity = new ScoringResultEntity(scoringResultAggregate.rootEntity.applicationNumber.toString(), scoringResultAggregate.getScorePoints(), scoringResultAggregate.getScoreColor(), detailedScoringResults);
		this.scoringResultDAO.save(scoringResultEntity);

	}

	@Override
	public ScoringResultAggregate findByApplicationNumber(ApplicationNumber applicationNumber) {
		ScoringResultEntity scoringResultEntity = scoringResultDAO.findByApplicationNumber(applicationNumber.toString());
		return new ScoringResultAggregate.Builder(applicationNumber)
				.agencyScoring(scoringResultEntity.getDetailedScoringResults().getAgencyScoringResult())
				.applicantScoring(scoringResultEntity.getDetailedScoringResults().getApplicantScoringResult())
				.financialSituationScoring(scoringResultEntity.getDetailedScoringResults().getFinancialSituationScoringResult())
				.noGoCriteria(scoringResultEntity.getDetailedScoringResults().isNoGoCriteriaPresent())
				.build();
	}
}
