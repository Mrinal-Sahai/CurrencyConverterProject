package com.mrinal.MainApp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiService {


//Add your own API key here, this one will not work
private final String apiKey="14jfuibiubb433ibi4ubiiu";

private final RestTemplate restTemplate;
private final ObjectMapper objectMapper;

public ApiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
}


//.................................................................................

public String getDataFromApi( String apiUrl) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-rapidapi-key", apiKey);
    headers.set("x-rapidapi-host", "fast-price-exchange-rates.p.rapidapi.com");

    HttpEntity<String> entity = new HttpEntity<>(headers);

    return restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class).getBody();
}

//Getting exchange rate............................................................................

public double getExchangeRate(String apiurl, String target) {
	System.out.println(apiurl);
	double exchangeRate=0;
    try {
       
        String jsonResponse = getDataFromApi(apiurl);
        System.out.println("API Respsone:" + jsonResponse);
        
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        
        exchangeRate = rootNode.get("to").get(target).asDouble();
        

    } catch (Exception e) {
        System.err.println("Failed to process due to  " + e);
       
    }
    
    return exchangeRate;
}

}

