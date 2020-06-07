/**
 * 
 */
package com.kunal.practice.example.tpicap.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author kunal
 *
 */
class FormatUtilTest {

	
	
	/**
	 * Test method for {@link com.kunal.practice.example.tpicap.utility.FormatUtil#extractPriceComponent(java.lang.String, int, boolean)}.
	 */
	@Test
	void testExtractPriceComponent() {
		
//		assertEquals("|4|7.9|2|", testInstance.displayPriceOfQuote("47.92",instrConfiguration));
		assertEquals("4", FormatUtil.extractPriceComponent("47.9", 2, true));
		assertEquals("15.2", FormatUtil.extractPriceComponent("15.23", 1, true));
		assertEquals("", FormatUtil.extractPriceComponent("18.0", 3, true));
		assertEquals("16.7", FormatUtil.extractPriceComponent("16.75", 1, true));
		
	}

	/**
	 * Test method for {@link com.kunal.practice.example.tpicap.utility.FormatUtil#removeTrailingZeros(java.lang.String)}.
	 */
	@Test
	void testRemoveTrailingZeros() {
		assertEquals("2", FormatUtil.removeTrailingZeros("200"));
		assertEquals("", FormatUtil.removeTrailingZeros("00"));
		assertEquals("101", FormatUtil.removeTrailingZeros("101"));
	}

}
