/**
 * This is DisplayPrice Service implementation class .
 * It has method which will display price of order or quote.
 * 
 * 
 */
package com.kunal.practice.example.tpicap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunal.practice.example.tpicap.model.InstrumentConfiguration;
import com.kunal.practice.example.tpicap.model.PriceComponent;
import com.kunal.practice.example.tpicap.shared.Constants;
import com.kunal.practice.example.tpicap.utility.FormatUtil;

/**
 * @author kunal
 *
 */
@Service
public class DisplayPriceImpl implements DisplayPrice {
	
	private final static Logger logger = LoggerFactory.getLogger(DisplayPriceImpl.class);

	@Autowired
	InstrumentConfiguration instrumentConfiguration;
	@Autowired
	PriceComponent priceComponent;

	/*
	 * This method returns the price of Quote. As mentioned earlier in requirement, the price has 3 components big figure, dealing price and fractional pips.
	 * It reads rawprice passed as input parameter , and applies display format by multiplying with a correct factor.
	 * Furthermore, it applies scaling configuration and extract fractional pip part of the price.
	 * Subsequently, it has common logic to extract remaining parts of the price from remaining raw price on the basis of string length and dealing price length
	 * and fractional pips length.
	 */
	
	@Override
	public PriceComponent getPriceOfQuote(String inputRawPrice, PriceComponent priceComponent) {

		this.priceComponent = priceComponent;
		this.instrumentConfiguration = priceComponent.getInstrumentConfiguration();

		Double displayPrice = applyDisplayFormatConfiguration(Double.parseDouble(inputRawPrice));

		String priceafterScaling = applyScaleConfiguration(displayPrice);

		logger.info("Price after scaling: " + priceafterScaling);

		logger.info("fraction pips: " + getFractionalPips(priceafterScaling));

		int fractionalPIPLength = this.instrumentConfiguration.getFractionalPIPLength();

		int priceafterScalingLength = priceafterScaling.length();

		String priceExcludingFractionalPips = priceafterScaling.substring(0,
				priceafterScalingLength - fractionalPIPLength);

		logger.info("dealingPrice: " + getDealingPrice(priceExcludingFractionalPips));

		logger.info("Big Figure: " + getBigFigure(priceExcludingFractionalPips));

		this.priceComponent.setBigFigure(getBigFigure(priceExcludingFractionalPips));
		this.priceComponent.setDealingPrice(getDealingPrice(priceExcludingFractionalPips));
		this.priceComponent.setFractionalPips(getFractionalPips(priceafterScaling));

		return this.priceComponent;

	}

	private String applyScaleConfiguration(Double dblRawPrice) {
		return String.format("%." + this.instrumentConfiguration.getScale() + "f", dblRawPrice.doubleValue());

	}

	private Double applyDisplayFormatConfiguration(Double rawPrice) {
		if (Constants.DECIMAL.equalsIgnoreCase(this.instrumentConfiguration.getDisplayFormat())) {
			rawPrice = rawPrice * Constants.DECIMAL_VALUE;
		} else if (Constants.PERCENTAGE.equalsIgnoreCase(this.instrumentConfiguration.getDisplayFormat())) {
			rawPrice = rawPrice * Constants.PERCENTAGE_VALUE;
		} else if (Constants.PER_MILE.equalsIgnoreCase(this.instrumentConfiguration.getDisplayFormat())) {
			rawPrice = rawPrice * Constants.PER_MILE_VALUE;
		} else if (Constants.BASIS_POINT.equalsIgnoreCase(this.instrumentConfiguration.getDisplayFormat())) {
			rawPrice = rawPrice * Constants.BASIS_POINT_VALUE;
		}
		return rawPrice;

	}

	private String getBigFigure(String price) {

		int dealingpricelengh = this.instrumentConfiguration.getDealingPriceLength();

		return FormatUtil.extractPriceComponent(price, dealingpricelengh, true);
	}

	private String getDealingPrice(String price) {

		int dealingpricelengh = this.instrumentConfiguration.getDealingPriceLength();

		return FormatUtil.extractPriceComponent(price, dealingpricelengh, false);
	}

	private String getFractionalPips(String price) {

		int fractionalPipLength = this.instrumentConfiguration.getFractionalPIPLength();

		String pricebeforeremovezeros = FormatUtil.extractPriceComponent(price, fractionalPipLength, false);

		return FormatUtil.removeTrailingZeros(pricebeforeremovezeros);

	}

}
