package com.ch10.sendobjectstoresponsebody.controller;

import com.ch10.sendobjectstoresponsebody.dto.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class CountryController {

    private Logger logger = Logger.getLogger(CountryController.class.getName());

    @GetMapping("/india")
    public Country getCountryInfo(){
        Country country = new Country();
        country.setName("india");
        country.setPopulation(140000);

        logger.info("Country Object "+country);

        return country;
    }

}
