package com.mploed.dddwithspring.scoring.agencyResult;

import com.mploed.dddwithspring.scoring.PersonId;
import com.mploed.dddwithspring.scoring.appservices.repositories.AgencyResultRepository;
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
		agencyResultProjection.setPersonId(agencyResultAggregate.getAgencyResultRootEntity().id.toString());
		agencyResultProjection.setPoints(agencyResultAggregate.getAgencyResultRootEntity().points);
		agencyResultAggregate.getAgencyResultRootEntity().getKoCriteria().forEach((KoCriteria element) ->
				agencyResultProjection.addKoCriteria(new AgencyMessage(element.getKey(), element.getMessageText())));

		agencyResultAggregate.getAgencyResultRootEntity().getWarningMessages().forEach((WarningMessage element) ->
				agencyResultProjection.addWarning(new AgencyMessage(element.getKey(), element.getMessageText())));
		dao.save(agencyResultProjection);

	}

	@Override
	public AgencyResultAggregate retrieve(PersonId personId) {
		AgencyResultProjection agencyResultProjection = dao.findByPersonId(personId.toString());
		if(agencyResultProjection != null) {
			AgencyResultAggregate.AgencyResultBuilder agencyResultBuilder = new AgencyResultAggregate.AgencyResultBuilder().personId(new PersonId(agencyResultProjection.getPersonId()))
					.withPoints(agencyResultProjection.getPoints());
			agencyResultProjection.getKoCriteria().forEach((AgencyMessage message) ->
					agencyResultBuilder.withKoCriteria(message.getKey(), message.getMessage()));
			agencyResultProjection.getWarnings().forEach((AgencyMessage message) ->
					agencyResultBuilder.withWarning(message.getKey(), message.getMessage()));
			return agencyResultBuilder.build();
		} else {
			return null;
		}

	}
}
