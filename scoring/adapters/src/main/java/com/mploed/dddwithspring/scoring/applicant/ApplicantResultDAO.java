package com.mploed.dddwithspring.scoring.applicant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantResultDAO extends JpaRepository<ApplicantResultProjection, Long> {
	ApplicantResultProjection findByApplicationNumber(String applicationNumber);
}
