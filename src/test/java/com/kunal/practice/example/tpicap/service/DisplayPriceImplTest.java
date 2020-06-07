/**
 * 
 */
package com.kunal.practice.example.tpicap.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.kunal.practice.example.tpicap.model.InstrumentConfiguration;
import com.kunal.practice.example.tpicap.model.PriceComponent;

/**
 * @author kunal
 *
 */
class DisplayPriceImplTest {

	DisplayPrice service = new DisplayPriceImpl();

	/**
	 * Test method for
	 * {@link com.kunal.practice.example.tpicap.service.DisplayPriceImpl#getPriceOfQuote(java.lang.String, com.kunal.practice.example.tpicap.model.PriceComponent)}.
	 */
	@Test
	void testGetPriceOfQuote() {
		PriceComponent priceComponent = new PriceComponent();
		InstrumentConfiguration instrConfiguration = new InstrumentConfiguration();
		instrConfiguration.setDisplayFormat("DECIMAL");
		instrConfiguration.setDealingPriceLength(2);
		instrConfiguration.setFractionalPIPLength(3);
		instrConfiguration.setScale(4);
		priceComponent.setInstrumentConfiguration(instrConfiguration);

		assertEquals("4", service.getPriceOfQuote("47.92", priceComponent).getBigFigure());
		assertEquals("7.9", service.getPriceOfQuote("47.92", priceComponent).getDealingPrice());
		assertEquals("2", service.getPriceOfQuote("47.92", priceComponent).getFractionalPips());

		PriceComponent priceComponent1 = new PriceComponent();
		InstrumentConfiguration instrConfiguration1 = new InstrumentConfiguration();
		instrConfiguration1.setDisplayFormat("PERCENTAGE");
		instrConfiguration1.setDealingPriceLength(1);
		instrConfiguration1.setFractionalPIPLength(2);
		instrConfiguration1.setScale(4);
		priceComponent1.setInstrumentConfiguration(instrConfiguration1);
		assertEquals("15.2", service.getPriceOfQuote("0.1523", priceComponent1).getBigFigure());
		assertEquals("3", service.getPriceOfQuote("0.1523", priceComponent1).getDealingPrice());
		assertEquals("", service.getPriceOfQuote("0.1523", priceComponent1).getFractionalPips());

		PriceComponent priceComponent2 = new PriceComponent();
		InstrumentConfiguration instrConfiguration2 = new InstrumentConfiguration();
		instrConfiguration2.setDisplayFormat("BASIS_POINT");
		instrConfiguration2.setDealingPriceLength(3);
		instrConfiguration2.setFractionalPIPLength(1);
		instrConfiguration2.setScale(2);
		priceComponent2.setInstrumentConfiguration(instrConfiguration2);
		assertEquals("", service.getPriceOfQuote("0.0018", priceComponent2).getBigFigure());
		assertEquals("18.0", service.getPriceOfQuote("0.0018", priceComponent2).getDealingPrice());
		assertEquals("", service.getPriceOfQuote("0.0018", priceComponent2).getFractionalPips());

		PriceComponent priceComponent3 = new PriceComponent();
		InstrumentConfiguration instrConfiguration3 = new InstrumentConfiguration();
		instrConfiguration3.setDisplayFormat("PERCENTAGE");
		instrConfiguration3.setDealingPriceLength(1);
		instrConfiguration3.setFractionalPIPLength(2);
		instrConfiguration3.setScale(4);
		priceComponent3.setInstrumentConfiguration(instrConfiguration3);
		assertEquals("16.7", service.getPriceOfQuote("0.16754", priceComponent3).getBigFigure());
		assertEquals("5", service.getPriceOfQuote("0.16754", priceComponent3).getDealingPrice());
		assertEquals("4", service.getPriceOfQuote("0.16754", priceComponent3).getFractionalPips());

	}

}
