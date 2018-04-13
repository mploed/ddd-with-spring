package com.mploed.dddwithspring.creditsalesfunnel.repository;

import com.mploed.dddwithspring.creditsalesfunnel.model.applicant.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	public Applicant findByApplicationNumberAndApplicantNumber(String applicationNumber, String applicantNumber);

	public List<Applicant> findByApplicationNumberOrderByApplicantNumber(String applicationNumber);
}
