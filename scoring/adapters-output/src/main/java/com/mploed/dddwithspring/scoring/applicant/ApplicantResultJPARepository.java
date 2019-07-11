package com.mploed.dddwithspring.scoring.applicant;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import com.mploed.dddwithspring.scoring.appservices.repositories.ApplicantResultRepository;
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
		projection.setApplicationNumber(applicantAggregate.getApplicationNumber().toString());
		projection.setPersonId(applicantAggregate.getPersonId().toString());
		projection.setBalance(applicantAggregate.getBalance().toBigDecimal());
		projection.setCity(applicantAggregate.getAddress().getCity());
		projection.setPostCode(applicantAggregate.getAddress().getPostCode());
		projection.setStreet(applicantAggregate.getAddress().getStreet());
		projection.setLastName(applicantAggregate.getLastName());
		projection.setName(applicantAggregate.getName());
		this.dao.save(projection);
	}

	@Override
	public ApplicantAggregate retrieve(ApplicationNumber applicationNumber) {
		ApplicantResultProjection projection = dao.findByApplicationNumber(applicationNumber.toString());
		if(projection != null) {
			return toApplicantAggregate(projection);
		} else {
			return null;
		}

	}


	@Override
	public ApplicantAggregate retrieve(PersonId personId) {
		ApplicantResultProjection projection = dao.findByPersonId(personId.toString());
		if(projection != null) {
			return toApplicantAggregate(projection);
		} else {
			return null;
		}
	}

	private ApplicantAggregate toApplicantAggregate(ApplicantResultProjection projection) {
		return new ApplicantAggregate.ApplicantAggregateBuilder(new ApplicationNumber(projection.getApplicationNumber()))
				.accountBalance(projection.getBalance())
				.city(projection.getCity())
				.postCode(projection.getPostCode())
				.street(projection.getStreet())
				.firstName(projection.getName())
				.lastName(projection.getLastName())
				.build();
	}
}
