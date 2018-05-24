package com.mploed.dddwithspring.scoring.applicant;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ApplicantResultJPARepository implements ApplicantResultRepository {

	private ApplicantResultDAO dao;

	@Autowired
	public ApplicantResultJPARepository(ApplicantResultDAO dao) {
		this.dao = dao;
	}


	@Override
	public void save(ApplicantAggregate applicantAggregate) {
		ApplicantResultProjection projection = new ApplicantResultProjection();
		projection.setApplicationNumber(applicantAggregate.applicantRootEntity.applicationNumber.toString());
		projection.setPersonId(applicantAggregate.applicantRootEntity.personId.toString());
		projection.setPoints(applicantAggregate.calculateScoringPoints());
		this.dao.save(projection);
	}

	@Override
	public ApplicantResultProjection retrieve(ApplicationNumber applicationNumber) {
		return dao.findByApplicationNumber(applicationNumber.toString());
	}

}
