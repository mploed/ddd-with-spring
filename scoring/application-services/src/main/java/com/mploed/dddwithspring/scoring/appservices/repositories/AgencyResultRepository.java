package com.mploed.dddwithspring.scoring.appservices.repositories;


import com.mploed.dddwithspring.scoring.PersonId;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;

public interface AgencyResultRepository {
	void save(AgencyResultAggregate agencyResultAggregate);

	AgencyResultAggregate retrieve(PersonId personId);
}
