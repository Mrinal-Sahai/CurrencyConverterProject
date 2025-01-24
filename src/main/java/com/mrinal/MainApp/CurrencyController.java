package com.mrinal.MainApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class CurrencyController {
	
	 @Autowired
	    private ApiService apiService;

    @GetMapping("/")
    public String showForm() {
        
        return "index";
    }

    @PostMapping("/convert")
    public String convertCurrency(
        @RequestParam("baseCurrency") String baseCurrency,
        @RequestParam("targetCurrency") String targetCurrency,
        @RequestParam("amount") Double amount,
        Model model) {
    	 String apiurl = "https://fast-price-exchange-rates.p.rapidapi.com/api/v1/rates?quote_currency="+targetCurrency+"&base_currency="+baseCurrency;
         double exchange=apiService.getExchangeRate(apiurl, targetCurrency);
    	 double finalAmount=exchange*amount;
    	 String formattedExchange = String.format("%.2f", exchange);
    	 String formattedFinalAmount = String.format("%.2f", finalAmount);
    	
        model.addAttribute("baseCurrency", baseCurrency);
        model.addAttribute("targetCurrency", targetCurrency);
        model.addAttribute("exchangeRate", formattedExchange);
        model.addAttribute("convertedAmount", formattedFinalAmount);
        model.addAttribute("amount", amount);
        System.out.println("Exchange  Rate= "+ formattedExchange);
        System.out.println(amount+" "+ baseCurrency+" = "+finalAmount+" "+targetCurrency);

       
        return "index";
    }
}

    

