package com.mploed.dddwithspring.scoring.applicant;


import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultProjection;

public interface ApplicantResultRepository {
	void save(ApplicantAggregate applicantAggregate);

	ApplicantResultProjection retrieve(ApplicationNumber applicationNumber);

	ApplicantResultProjection retrieve(PersonId personId);
}
