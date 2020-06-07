/**
 * 
 */
package com.kunal.practice.example.tpicap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kunal.practice.example.tpicap.model.InstrumentConfiguration;
import com.kunal.practice.example.tpicap.model.PriceComponent;
import com.kunal.practice.example.tpicap.service.DisplayPrice;

/**
 * @author kunal
 *
 */

@Controller
@RequestMapping("/home")
public class HomeController {

	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DisplayPrice displayService;

	public HomeController(DisplayPrice displayService) {
		this.displayService = displayService;
	}

	@RequestMapping("/inputform")
	public String displayPrice(Model priceModel) {
		priceModel.addAttribute("InstrumentConfiguration", new InstrumentConfiguration());
//		priceModel.addAttribute("PriceComponent", new PriceComponent());

		logger.info("In HomeController.displayPrice() method");
		logger.info("The priceModel :");
		logger.info("" + priceModel);
		return "inputform";

	}

	
	@RequestMapping("/formatprice")

	public String processForm(
			@ModelAttribute("InstrumentConfiguration") InstrumentConfiguration instrumentConfiguration,
			@RequestParam String rawPrice, Model theModel) {

		PriceComponent priceComponent = new PriceComponent();

		priceComponent.setInstrumentConfiguration(instrumentConfiguration);

		priceComponent = displayService.getPriceOfQuote(rawPrice, priceComponent);

		theModel.addAttribute("PriceComponent", priceComponent);

		theModel.addAttribute("rawPrice", rawPrice);

		logger.info("In HomeController.processForm() method");
		logger.info("The priceComponent :" + priceComponent);
		logger.info("The rawPrice :" + rawPrice);
		return "displayprice";
	}
}
