/**
 * 
 */
package com.jpmorgan.assignment.service;

import com.jpmorgan.assignment.model.Stock;
import com.jpmorgan.assignment.model.Trade;
import com.jpmorgan.assignment.model.Trade.TradeType;

/**
 * @author Zeeshan Saeed
 *
 */
public interface TradeService {

	public abstract Trade addTrade (final Stock stock, final Integer sharesQuantity
									  ,final TradeType tradeType, final Double price);
}
