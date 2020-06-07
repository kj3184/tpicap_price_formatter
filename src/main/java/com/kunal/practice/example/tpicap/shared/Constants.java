/**
 *  This Class contains all the constant values used in the project.
 */
package com.kunal.practice.example.tpicap.shared;

import org.springframework.stereotype.Component;

/**
 * @author kunal
 *
 */

@Component
public final class Constants {
	
	
	public static final String DECIMAL = "DECIMAL";
	public static final String PERCENTAGE = "PERCENTAGE";
	public static final String PER_MILE = "PER_MILE";
	public static final String BASIS_POINT = "BASIS_POINT";
	
	public static final int DECIMAL_VALUE = 1;
	public static final int PERCENTAGE_VALUE = 100;
	public static final int PER_MILE_VALUE = 1000;
	public static final int BASIS_POINT_VALUE = 10000;
	
	
	
	private Constants() {
		// this is to restrict unnecessary instantiation
	} 
	

}
