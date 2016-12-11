/**
 * 
 */
package com.jpmorgan.assignment.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jpmorgan.assignment.model.Stock;
import com.jpmorgan.assignment.model.Stock.StockType;
import com.jpmorgan.assignment.model.Trade;
import com.jpmorgan.assignment.service.StockService;

/**
 * @author Zeeshan Saeed
 *
 */
public class StockServiceImplTest {

	/*
	 * There could be many Junit test for this class, I am just writing test for one scenario only
	 * due to limitation of time.
	 * 
	 */
	private StockService stockService = StockServiceImpl.getSingletonInstance();
	
	@Test
	public void testSingletonInstance () {
		StockService secondStockService = StockServiceImpl.getSingletonInstance();
		
		assertTrue(secondStockService.equals(stockService));
	}
	
	@Test
	public void testCalculatedDividendYield () {
		Stock stock = new Stock();
		Trade trade = new Trade();
		stock.setStockType(StockType.COMMON);
		stock.setLastDividend(4d);
		trade.setPrice(2d);
		
		Double result = this.stockService.calculateDividendYield(stock, trade, StockType.COMMON);
		
		assertEquals(2d, result.doubleValue(), 0);
	}
	

}
