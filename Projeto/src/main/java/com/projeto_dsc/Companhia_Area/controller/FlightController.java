package com.projeto_dsc.Companhia_Area.controller;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.Value;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final RestTemplate restTemplate = new RestTemplate();




	  @GetMapping("/track")
    public ResponseEntity<String> trackFlight(@RequestParam String flightNumber) {
        String apiUrl = "https://api.aviationstack.com/v1/flights?access_key=83ddbf18b2b9eeb460950f3117f1ed39" + "&flight_iata=" + flightNumber;
		String response = restTemplate.getForObject(apiUrl, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<String> flightHistory(@RequestParam String flightNumber) {
        String apiUrl = "http://https://api.aviationstack.com/v1/flights?access_key=83ddbf18b2b9eeb460950f3117f1ed39" + "&flight_iata=" + flightNumber;
        String response = restTemplate.getForObject(apiUrl, String.class);
        return ResponseEntity.ok(response);
    }
}
