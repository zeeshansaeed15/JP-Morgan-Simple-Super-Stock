/**
 * 
 */
package com.jpmorgan.assignment.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jpmorgan.assignment.model.Stock.StockType;

/**
 * @author Zeeshan Saeed
 *
 */
public class StockTest {
	/*
	 * There could be many Junit test for getter/setter methods, enum and covering
	 * other scenarios, However, I am writing only some due to limitation of
	 * time.
	 */

	@Test
	public void testCreateStockUsingZeroArgumentConstructor() {
		Stock stock = new Stock();
		
		assertNotNull(stock);
		assertNotNull(stock.getId());
	}
	
	@Test
	public void testCreateStockUsingNonDefaultConstructor() {
		Stock stock = new Stock("TEA", StockType.COMMON, 100D, null, 0D);
		
		assertNotNull(stock);
		assertNotNull(stock.getId());
	}
	
	@Test
	public void testStockIncrementCounter() {
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
	    long firstIncrement = stock1.getId();
	    long secondIncrement = stock2.getId();
		
		assertEquals(firstIncrement + 1, secondIncrement, 0);
	}
	
	@Test
	public void whenTwoStockObjectsHaveSameIdThenTheyShouldBeEqual() {
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		stock2.setId(stock1.getId());
		
		assertTrue(stock1.equals(stock2));
	}
}
