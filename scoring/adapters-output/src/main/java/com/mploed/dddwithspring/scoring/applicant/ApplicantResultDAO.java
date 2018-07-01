package com.mploed.dddwithspring.scoring.applicant;

import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultProjection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantResultDAO extends JpaRepository<ApplicantResultProjection, Long> {
	ApplicantResultProjection findByApplicationNumber(String applicationNumber);

	ApplicantResultProjection findByPersonId(String personId);

}
