/**
 * 
 */
package com.jpmorgan.assignment.service.impl;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import com.jpmorgan.assignment.model.Stock;
import com.jpmorgan.assignment.model.Trade;
import com.jpmorgan.assignment.model.Trade.TradeType;
import com.jpmorgan.assignment.service.TradeService;

/**
 * @author Zeeshan Saeed
 *
 */
public class TradeServiceImpl implements TradeService {
	
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private volatile static TradeService tradeServiceSingletonInstance;
	
    private TradeServiceImpl() {} 
    
    public static TradeService getSingletonInstance() {
        if (null == tradeServiceSingletonInstance) {
        	synchronized (TradeServiceImpl.class) {
        		if (null == tradeServiceSingletonInstance) {
        			tradeServiceSingletonInstance = new TradeServiceImpl();
        		}
			}
        }
        return tradeServiceSingletonInstance;
    }

	@Override
	public Trade addTrade(final Stock stock, final Integer sharesQuantity, final TradeType tradeType, final Double price) {
		Trade trade = new Trade(stock, LocalDateTime.now(), sharesQuantity, tradeType, price);
		
		return trade;
	}
}