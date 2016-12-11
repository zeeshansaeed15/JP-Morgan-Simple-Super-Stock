/**
 * 
 */
package com.jpmorgan.assignment.model;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * @author Zeeshan Saeed
 *
 */
public class Trade extends CommonData {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private static long tradeCounter = 0;
	
	public static enum TradeType {
		  BUY,
		  SELL
	}
	
	private Stock stock;

	private LocalDateTime tradeTime = LocalDateTime.now();

	private Integer sharesQuantity;

	private TradeType tradeType;

	private Double price;
	
	public Trade(){
		this.setId(Trade.incrementTradeCounter());
	}
	
	public Trade(Stock stock, LocalDateTime tradeTime,
					Integer sharesQuantity, TradeType tradeType, 
					Double price) {
		this.setId(Trade.incrementTradeCounter());
		this.stock = stock;
		this.tradeTime = tradeTime;
		this.sharesQuantity = sharesQuantity;
		this.tradeType = tradeType;
		this.price = price;
	}
	
	public synchronized static long incrementTradeCounter () {
		return ++tradeCounter;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * @return the tradeTime
	 */
	public LocalDateTime getTradeTime() {
		return tradeTime;
	}

	/**
	 * @param tradeTime the tradeTime to set
	 */
	public void setTradeTime(LocalDateTime tradeTime) {
		this.tradeTime = tradeTime;
	}

	/**
	 * @return the sharesQuantity
	 */
	public Integer getSharesQuantity() {
		return sharesQuantity;
	}

	/**
	 * @param sharesQuantity the sharesQuantity to set
	 */
	public void setSharesQuantity(Integer sharesQuantity) {
		this.sharesQuantity = sharesQuantity;
	}

	/**
	 * @return the tradeType
	 */
	public TradeType getTradeType() {
		return tradeType;
	}

	/**
	 * @param tradeType the tradeType to set
	 */
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
}