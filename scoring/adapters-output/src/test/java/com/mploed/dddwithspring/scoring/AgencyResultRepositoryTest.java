package com.mploed.dddwithspring.scoring;

import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultJPARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgencyResultRepositoryTest {
	@Autowired
	private AgencyResultJPARepository repository;

	@Test
	public void testSave() {
		AgencyResultAggregate aggregate = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "teststr", "40789", "Testcity")
				.withPoints(100)
				.withWarning("234", "test")
				.withKoCriteria("123", "test test")
				.withKoCriteria("342", "testing")
				.build();

		repository.save(aggregate);

		AgencyResultAggregate resultAggregate = repository.retrieve(aggregate.getPersonId());

		assertThat(resultAggregate.getPersonId().toString()).isEqualTo(aggregate.getPersonId().toString());
	}
}
