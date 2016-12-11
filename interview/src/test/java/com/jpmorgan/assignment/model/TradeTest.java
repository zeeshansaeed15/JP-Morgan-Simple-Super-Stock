/**
 * 
 */
package com.jpmorgan.assignment.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

import com.jpmorgan.assignment.model.Trade.TradeType;

/**
 * @author Zeeshan Saeed
 *
 */
public class TradeTest {
	/*
	 * There could be many Junit test for getter/setter methods, enum and covering
	 * other scenarios, However, I am writing only some due to limitation of
	 * time.
	 */

	@Test
	public void testCreateTradeUsingZeroArgumentConstructor() {
		Trade trade = new Trade();
		
		assertNotNull(trade);
		assertNotNull(trade.getId());
	}
	
	@Test
	public void testCreateTradeUsingNonDefaultConstructor() {
		Stock stock = new Stock();
		Trade trade = new Trade(stock, LocalDateTime.now(), 1, TradeType.BUY, 100d);
		
		assertNotNull(trade);
		assertNotNull(trade.getId());
	}
	
	@Test
	public void testStockIncrementCounter() {
		Trade trade1 = new Trade();
		Trade trade2 = new Trade();
	    long firstIncrement = trade1.getId();
	    long secondIncrement = trade2.getId();
		
		assertEquals(firstIncrement + 1, secondIncrement, 0);
	}
	
	@Test
	public void whenTwoTradeObjectsHaveSameIdThenTheyShouldbeEqual() {
		Trade trade1 = new Trade();
		Trade trade2 = new Trade();
		trade2.setId(trade1.getId());
		
		assertTrue(trade1.equals(trade2));
	}
}