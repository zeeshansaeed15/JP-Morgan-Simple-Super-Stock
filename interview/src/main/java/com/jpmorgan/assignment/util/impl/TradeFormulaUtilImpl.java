/**
 * 
 */
package com.jpmorgan.assignment.util.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Logger;

import com.jpmorgan.assignment.model.Trade;
import com.jpmorgan.assignment.util.TradeFormulaUtil;

/**
 * @author Zeeshan Saeed
 *
 */
public class TradeFormulaUtilImpl implements TradeFormulaUtil {
	
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger (this.getClass().getName());
	
	private volatile static TradeFormulaUtil tradeFormulaUtilSingletonInstance;
	
	public TradeFormulaUtilImpl(){}
	
    
    public static TradeFormulaUtil getSingletonInstance() {
        if (null == tradeFormulaUtilSingletonInstance) {
        	synchronized (TradeFormulaUtilImpl.class) {
        		if (null == tradeFormulaUtilSingletonInstance) {
        			tradeFormulaUtilSingletonInstance = new TradeFormulaUtilImpl();
        		}
			}
        }
        return tradeFormulaUtilSingletonInstance;
    }


	public Double calculateDividendYield (final Double lastDividend, final Double price) throws ArithmeticException, NumberFormatException {
		Double result = null;
		if (lastDividend != null
				&& price != null ) {
			result = lastDividend.doubleValue() / price.doubleValue();
			result = this.round(result, 2);
		}
	    
	    return result;
	}

	public Double calculateDividendYield (final Double fixedDividend, final Double price
											, Double parValue) throws ArithmeticException, NumberFormatException {
		Double result = null;
		if (fixedDividend != null
				&& price != null
				&& parValue != null) {
			result = (fixedDividend.doubleValue() * parValue.doubleValue()) / price.doubleValue();
			result = this.round(result, 2);
		}
	    return result;
	}

	public Double calculatePERatio (final Double price, final Double lastDividend) throws ArithmeticException, NumberFormatException {
		Double result = null;
		if (lastDividend != null
				&& price != null) {
			result =  price.doubleValue() / lastDividend.doubleValue();
			result = this.round(result, 2);
		}
	    return result;
	}

	public Double calculateGBCE (final List<Trade> trades) throws ArithmeticException, NumberFormatException {
		Double result = null;
		if (trades != null
				&& !trades.isEmpty()) {
			result = trades.parallelStream().mapToDouble(t -> t.getPrice())
								   .reduce(1,  (a, b) -> (a * b));
		    result = Math.pow(result.doubleValue(), (1D / trades.size()));
		    this.round(result, 2);
		}

	    return result;
	}

	public Double calculateVolumeWeightedStockPrice (final List<Trade> trades) throws ArithmeticException, NumberFormatException {
		Double result = null;
		if (trades != null
				&& !trades.isEmpty()) {
		    double sumOfPriceQuantity = 0;
		    int sumOfShareQuantity = 0;

		    for (Trade trade : trades) {
		      sumOfPriceQuantity = sumOfPriceQuantity + (trade.getPrice() * trade.getSharesQuantity());
		      sumOfShareQuantity = sumOfShareQuantity + trade.getSharesQuantity();
		    }
		    result = sumOfPriceQuantity / sumOfShareQuantity;
		    result = this.round(result, 2);
		}

	    return result;
	}
	
    private Double round(Double value, int places) throws NumberFormatException {
	    BigDecimal bd = new BigDecimal(value.doubleValue());
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}