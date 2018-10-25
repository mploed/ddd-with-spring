package com.mploed.dddwithspring.scoring;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoneyTest {

	@Test
	public void testIsGreaterThan() {
		Money base = new Money(8000);
		assertTrue(base.isGreaterThan(new Money(7000)));
		assertFalse(base.isGreaterThan(new Money(8000)));
	}

	@Test
	public void testAdd() {
		Money base = new Money();
		assertEquals(BigDecimal.ZERO, base.getAmount());
		Money moneyToAdd = new Money(100);
		assertEquals(new Money(100), base.add(moneyToAdd));
	}
}
