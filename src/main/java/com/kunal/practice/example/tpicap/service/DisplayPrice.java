/**
 * This is DisplayPrice Service interface .
 * It has method which will display price of order or quote.
 * 
 */
package com.kunal.practice.example.tpicap.service;

import com.kunal.practice.example.tpicap.model.PriceComponent;

/**
 * @author kunal
 *
 */
public interface DisplayPrice {
	
	public PriceComponent getPriceOfQuote(String rawPrice, PriceComponent priceComponent) ;

}
