/**
 * 
 */
package com.jpmorgan.assignment.util.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jpmorgan.assignment.util.TradeFormulaUtil;

/**
 * @author Zeeshan Saeed
 *
 */
public class TradeFormulaUtilTest {
	/*
	 * There could be many Junit test for this class, I am just writing test for one scenario only
	 * due to limitation of time.
	 * 
	 */
	private TradeFormulaUtil tradeFormulaUtil = TradeFormulaUtilImpl.getSingletonInstance();
	
	@Test
	public void testSingletonInstance () {
		TradeFormulaUtil secondTradeFormulaUtilInstance = TradeFormulaUtilImpl.getSingletonInstance();
		
		assertTrue(secondTradeFormulaUtilInstance.equals(tradeFormulaUtil));
	}
	

	@Test
	public void testCalculateDividendYield () {
		double lastDividend = 4d;
		double price = 2d;
		double result = this.tradeFormulaUtil.calculateDividendYield(lastDividend, price);
		
		assertEquals(2d, result, 0);
	}
	
	@Test
	public void whenLastDividendIsNullForCalculateDividendYieldThenResultIsNull () {
		Double lastDividend = null;
		Double price = 2d;
		Double result = this.tradeFormulaUtil.calculateDividendYield(lastDividend, price);
		
		assertNull(result);
	}
	
	@Test
	public void whenPriceIsNullForCalculateDividendYieldThenResultIsNull () {
		Double lastDividend = 1d;
		Double price = null;
		Double result = this.tradeFormulaUtil.calculateDividendYield(lastDividend, price);
		
		assertNull(result);
	}
	
	@Test(expected=NumberFormatException.class)
	public void whenPriceIsZeroForCalculatingDividendYieldThenThrowsNumberFormatException () {
		Double lastDividend = 2d;
		Double price = 0d;
		Double result = this.tradeFormulaUtil.calculateDividendYield(lastDividend, price);
	}
}
