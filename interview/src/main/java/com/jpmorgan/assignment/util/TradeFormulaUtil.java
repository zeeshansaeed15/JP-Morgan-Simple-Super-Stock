package com.jpmorgan.assignment.util;

import java.util.List;

import com.jpmorgan.assignment.model.Trade;

public interface TradeFormulaUtil {
	
	public abstract Double calculateDividendYield (final Double lastDividend, final Double price) throws ArithmeticException, NumberFormatException;
	
	public abstract Double calculateDividendYield (final Double fixedDividend, final Double price
													, final Double parValue) throws ArithmeticException, NumberFormatException;
	
	public abstract Double calculatePERatio (final Double price, final Double lastDividend) throws ArithmeticException, NumberFormatException;
	
	public abstract Double calculateGBCE (final List<Trade> trades) throws ArithmeticException, NumberFormatException;
	
	public abstract Double calculateVolumeWeightedStockPrice (final List<Trade> trades) throws ArithmeticException, NumberFormatException;

}
