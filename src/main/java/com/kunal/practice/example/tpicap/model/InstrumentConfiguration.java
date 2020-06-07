/**
 * This is instrument configuration class, it has instrument configuration details such as display format,scale, dealing price length and 
 * fractional pip length
 */
package com.kunal.practice.example.tpicap.model;

import org.springframework.stereotype.Component;

/**
 * @author kunal
 *
 */

@Component
public class InstrumentConfiguration {

	String displayFormat;
	Integer scale;
	Integer dealingPriceLength;
	Integer fractionalPIPLength;
	/**
	 * @return the displayFormat
	 */
	public String getDisplayFormat() {
		return displayFormat;
	}
	/**
	 * @param displayFormat the displayFormat to set
	 */
	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}
	/**
	 * @return the scale
	 */
	public Integer getScale() {
		return scale;
	}
	/**
	 * @param scale the scale to set
	 */
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	/**
	 * @return the dealingPriceLength
	 */
	public Integer getDealingPriceLength() {
		return dealingPriceLength;
	}
	/**
	 * @param dealingPriceLength the dealingPriceLength to set
	 */
	public void setDealingPriceLength(Integer dealingPriceLength) {
		this.dealingPriceLength = dealingPriceLength;
	}
	/**
	 * @return the fractionalPIPLength
	 */
	public Integer getFractionalPIPLength() {
		return fractionalPIPLength;
	}
	/**
	 * @param fractionalPIPLength the fractionalPIPLength to set
	 */
	public void setFractionalPIPLength(Integer fractionalPIPLength) {
		this.fractionalPIPLength = fractionalPIPLength;
	}
	
	
	
}
