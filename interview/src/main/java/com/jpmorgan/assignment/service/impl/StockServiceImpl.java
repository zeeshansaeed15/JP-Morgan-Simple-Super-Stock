/**
 * 
 */
package com.jpmorgan.assignment.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.jpmorgan.assignment.model.Stock;
import com.jpmorgan.assignment.model.Stock.StockType;
import com.jpmorgan.assignment.model.Trade;
import com.jpmorgan.assignment.service.StockService;
import com.jpmorgan.assignment.util.TradeFormulaUtil;
import com.jpmorgan.assignment.util.impl.TradeFormulaUtilImpl;

/**
 * @author Zeeshan Saeed
 *
 */
public class StockServiceImpl implements StockService {
	
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private volatile static StockService stockServiceSingletonInstance;
	private TradeFormulaUtil tradeFormulaUtil = TradeFormulaUtilImpl.getSingletonInstance();
	
    private StockServiceImpl() {} 
    
    public static StockService getSingletonInstance() {
        if (null == stockServiceSingletonInstance) {
        	synchronized (StockServiceImpl.class) {
        		if (null == stockServiceSingletonInstance) {
        			stockServiceSingletonInstance = new StockServiceImpl();
        		}
			}
        }
        return stockServiceSingletonInstance;
    }
    
	@Override
	public Stock addStock(final String stockSymbol, final StockType stockType
						   , final Double lastDividend, final Double fixedDividend,	final Double parValue) {
		Stock stock = new Stock(stockSymbol, stockType, lastDividend, fixedDividend, parValue);
		 
		return stock;
	}
	
	@Override
	public Double calculateDividendYield(Stock stock, Trade trade, StockType stockType) throws ArithmeticException, NumberFormatException {
		Double result = null;
		
		if (stockType.equals(StockType.COMMON)) {
			result = this.tradeFormulaUtil.calculateDividendYield(stock.getLastDividend(), trade.getPrice());
		} else if (stockType.equals(StockType.PREFERRED)) {
			result = this.tradeFormulaUtil.calculateDividendYield(stock.getFixedDividend(), trade.getPrice(), stock.getParValue());
		}

		return result;
	}


	@Override
	public Double calculatePERatio(Stock stock, Trade trade) throws ArithmeticException, NumberFormatException {
		Double result = null;		
		result = this.tradeFormulaUtil.calculatePERatio(trade.getPrice(), stock.getLastDividend());
		
		return result;
	}

	@Override
	public Double calculateGBCE(List<Trade> trades) throws ArithmeticException, NumberFormatException {
		Double result = null;	
		result = this.tradeFormulaUtil.calculateGBCE(trades);

		return result;
	}

	@Override
	public Double calculateVolumeWeightedStockPrice(List<Trade> trades) throws ArithmeticException, NumberFormatException {
		List<Trade> filteredTrades = trades.parallelStream()
										   .filter(t -> ChronoUnit.MINUTES.between(t.getTradeTime(), LocalDateTime.now()) <= 15)
							               .collect(Collectors.toList());
		
		Double result = null;	
		result = this.tradeFormulaUtil.calculateVolumeWeightedStockPrice(filteredTrades);

		return result;
	}
}