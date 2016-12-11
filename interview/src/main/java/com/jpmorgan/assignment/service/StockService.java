/**
 * 
 */
package com.jpmorgan.assignment.service;

import java.util.List;

import com.jpmorgan.assignment.model.Stock;
import com.jpmorgan.assignment.model.Stock.StockType;
import com.jpmorgan.assignment.model.Trade;

/**
 * @author Zeeshan Saeed
 *
 */
public interface StockService {
	
	public abstract Stock addStock (final String stockSymbol, final StockType stockType
									 ,final Double lastDividend, final Double fixedDividend, final Double parValue);
	
	public abstract Double calculateDividendYield (final Stock stock, final Trade trade, StockType stockType) throws ArithmeticException, NumberFormatException;
	
	public abstract Double calculatePERatio (final Stock stock, final Trade trade) throws ArithmeticException, NumberFormatException;
	
	public abstract Double calculateGBCE (final List<Trade> trades) throws ArithmeticException, NumberFormatException;
	
	public abstract Double calculateVolumeWeightedStockPrice (final List<Trade> trades) throws ArithmeticException, NumberFormatException;
}