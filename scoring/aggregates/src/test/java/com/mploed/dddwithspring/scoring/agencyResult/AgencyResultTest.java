package com.mploed.dddwithspring.scoring.agencyResult;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AgencyResultTest {

	@Test
	public void testScoring0Ko0Warn95Points() {
		AgencyResultAggregate agencyResultAggregate = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "München")
				.withPoints(95)
				.build();


		assertTrue(agencyResultAggregate.isAcceptable());
		assertEquals(20, agencyResultAggregate.calculateScoringPoints());
	}

	@Test
	public void testScoring0Ko6Warn95Points() {
		AgencyResultAggregate agencyResultAggregate = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "München")
				.withPoints(95)
				.withWarning("1", "---")
				.withWarning("2", "---")
				.withWarning("3", "---")
				.withWarning("4", "---")
				.withWarning("5", "---")
				.withWarning("6", "---")
				.build();
		assertFalse(agencyResultAggregate.isAcceptable());
		assertEquals(15, agencyResultAggregate.calculateScoringPoints());
	}

	@Test
	public void testScoring0Ko0Warn83Points() {
		AgencyResultAggregate agencyResultAggregate = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "München")
				.withPoints(83)
				.build();
		assertTrue(agencyResultAggregate.isAcceptable());
		assertEquals(10, agencyResultAggregate.calculateScoringPoints());
	}

	@Test
	public void testScoring0Ko0Warn90Points() {
		AgencyResultAggregate agencyResultAggregate = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "München")
				.withPoints(90)
				.build();
		assertTrue(agencyResultAggregate.isAcceptable());
		assertEquals(15, agencyResultAggregate.calculateScoringPoints());
	}

	@Test
	public void testScoring0Ko1Warn90Points() {
		AgencyResultAggregate agencyResultAggregate = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "München")
				.withWarning("00", "has only money for cheap pug food")
				.withPoints(90)
				.build();
		assertTrue(agencyResultAggregate.isAcceptable());
		assertEquals(10, agencyResultAggregate.calculateScoringPoints());
	}

	@Test
	public void testScoring1Ko0Warn90Points() {
		AgencyResultAggregate agencyResultAggregate = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "München")
				.withKoCriteria("200", "is bankrupt")
				.withPoints(90)
				.build();
		assertFalse(agencyResultAggregate.isAcceptable());
		assertEquals(0, agencyResultAggregate.calculateScoringPoints());
	}

}
