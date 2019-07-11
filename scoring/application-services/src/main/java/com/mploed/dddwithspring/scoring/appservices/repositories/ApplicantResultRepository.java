package com.mploed.dddwithspring.scoring.appservices.repositories;


import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;

public interface ApplicantResultRepository {
	void save(ApplicantAggregate applicantAggregate);

	ApplicantAggregate retrieve(ApplicationNumber applicationNumber);

	ApplicantAggregate retrieve(PersonId personId);
}
