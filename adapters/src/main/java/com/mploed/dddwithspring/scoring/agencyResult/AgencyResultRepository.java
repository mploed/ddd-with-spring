package com.mploed.dddwithspring.scoring.agencyResult;


import com.mploed.dddwithspring.scoring.PersonId;

public interface AgencyResultRepository {
	void save(AgencyResultAggregate agencyResultAggregate);

	AgencyResultProjection retrieve(PersonId personId);
}
