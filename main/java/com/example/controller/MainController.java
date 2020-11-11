package com.example.controller;

import com.example.resources.Current;
import com.example.resources.General;
import com.example.resources.Location;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@RestController
public class MainController {

    private static String url = "http://api.weatherapi.com/v1/current.json?key=6a5bfb7354774e43b1c105914200911&q=";

    @Autowired
    private final RestTemplate restTemplate;


    @GetMapping("/{q}")
    public General getTemps(@PathVariable("q") String q){

        Location location = new Location();
        Current current = new Current();
        location.setName(q);
        url = url + location.getName();
        General general = restTemplate.getForObject(url, General.class);
        current.setTemp_c(general.getCurrent().getTemp_c());
        general.setCurrent(current);
        general.setLocation(location);
        return general;

    }

}
