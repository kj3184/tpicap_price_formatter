/**
 * This class is an important entity in the project .
 * Each price of order or quote has three components ie big figure, dealing price, and fractional pips.
 * It also has Instrument configurations such as display format , scale , dealing price length and fractional pip length.
 * 
 * 
 */
package com.kunal.practice.example.tpicap.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kunal
 *
 */

@Component
public class PriceComponent {

	String bigFigure;
	String dealingPrice;
	String fractionalPips;

	@Autowired
	InstrumentConfiguration instrumentConfiguration;

	/**
	 * @return the bigFigure
	 */
	public String getBigFigure() {
		return bigFigure;
	}

	/**
	 * @param bigFigure the bigFigure to set
	 */
	public void setBigFigure(String bigFigure) {
		this.bigFigure = bigFigure;
	}

	/**
	 * @return the dealingPrice
	 */
	public String getDealingPrice() {
		return dealingPrice;
	}

	/**
	 * @param dealingPrice the dealingPrice to set
	 */
	public void setDealingPrice(String dealingPrice) {
		this.dealingPrice = dealingPrice;
	}

	/**
	 * @return the fractionalPips
	 */
	public String getFractionalPips() {
		return fractionalPips;
	}

	/**
	 * @param fractionalPips the fractionalPips to set
	 */
	public void setFractionalPips(String fractionalPips) {
		this.fractionalPips = fractionalPips;
	}

	/**
	 * @return the instrumentConfiguration
	 */
	public InstrumentConfiguration getInstrumentConfiguration() {
		return instrumentConfiguration;
	}

	/**
	 * @param instrumentConfiguration the instrumentConfiguration to set
	 */
	public void setInstrumentConfiguration(InstrumentConfiguration instrumentConfiguration) {
		this.instrumentConfiguration = instrumentConfiguration;
	}

	
	
	
	
}
