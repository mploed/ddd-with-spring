package com.mploed.dddwithspring.scoring.agencyResult;

import com.mploed.dddwithspring.scoring.PersonId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AgencyResultJPARepository implements AgencyResultRepository {

	private AgencyResultDAO dao;

	@Autowired
	public AgencyResultJPARepository(AgencyResultDAO dao) {
		this.dao = dao;
	}

	@Override
	public void save(AgencyResultAggregate agencyResultAggregate) {
		AgencyResultProjection agencyResultProjection = new AgencyResultProjection();
		agencyResultProjection.setNoGoPresent(!agencyResultAggregate.isAcceptable());
		agencyResultProjection.setPersonId(agencyResultAggregate.getAgencyResultRootEntity().id.toString());
		agencyResultProjection.setPoints(agencyResultAggregate.calculateScoringPoints());
		dao.save(agencyResultProjection);

	}

	@Override
	public AgencyResultProjection retrieve(PersonId personId) {
		return dao.findByPersonId(personId.toString());
	}
}
