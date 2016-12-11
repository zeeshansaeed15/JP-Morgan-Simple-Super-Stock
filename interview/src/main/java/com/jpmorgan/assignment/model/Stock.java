/**
 * 
 */
package com.jpmorgan.assignment.model;

import java.util.logging.Logger;

/**
 * @author Zeeshan Saeed
 *
 */
public class Stock extends CommonData {
	
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private static long stockCounter = 0;

	public static enum StockType {
		COMMON,
		PREFERRED
	}
	
	private String stockSymbol;
	
	private StockType stockType;
	
	private Double lastDividend;
	
	private Double fixedDividend;

	private Double parValue;

	public Stock (){
		this.setId(Stock.incrementStockCounter());
	}
	
	public Stock (String stockSymbol,
			 		StockType stockType, Double lastDividend
			 		, Double fixedDividend, Double parValue){
		this.setId(Stock.incrementStockCounter());
		this.stockSymbol = stockSymbol;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	
	public synchronized static long incrementStockCounter () {
		return ++stockCounter;
	}

	/**
	 * @return the stockSymbol
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}

	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	/**
	 * @return the stockType
	 */
	public StockType getStockType() {
		return stockType;
	}

	/**
	 * @param stockType the stockType to set
	 */
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	/**
	 * @return the lastDividend
	 */
	public Double getLastDividend() {
		return lastDividend;
	}

	/**
	 * @param lastDividend the lastDividend to set
	 */
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	/**
	 * @return the fixedDividend
	 */
	public Double getFixedDividend() {
		return fixedDividend;
	}

	/**
	 * @param fixedDividend the fixedDividend to set
	 */
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	/**
	 * @return the parValue
	 */
	public Double getParValue() {
		return parValue;
	}

	/**
	 * @param parValue the parValue to set
	 */
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
}