/**
 * 
 */
package com.kunal.practice.example.tpicap.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author kunal
 *
 */

@Component
public class FormatUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(FormatUtil.class);

	public static String extractPriceComponent(String price, int priceLength, boolean isBigFigure) {
		
		logger.info("In FormatUtil.extractPriceComponent() method");
		logger.info("The inputs entered:");
		logger.info("price:" + price);
		logger.info("priceLength:" + priceLength);
		logger.info("isBigFigure:" + isBigFigure);
		
		if (price.substring(price.length() - priceLength).indexOf(".") == -1) {
			if (!isBigFigure) {
				return price.substring(price.length() - priceLength);
			} else {
				return price.substring(0, price.length() - priceLength);
			}
		} else {
			if (!isBigFigure) {
				return price.substring(price.length() - priceLength - 1);
			} else {
				return price.substring(0, price.length() - priceLength - 1);
			}
		}
	}

	public static String removeTrailingZeros(String price) {

		logger.info("In FormatUtil.removeTrailingZeros() method");
		logger.info("The inputs entered:");
		logger.info("price:" + price);
		
		String trailingZerosPattern = "0*$";

		return price.replaceAll(trailingZerosPattern, "");

	}

}
