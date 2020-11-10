package com.example.controller;

import com.example.resources.Condition;
import com.example.resources.Current;
import com.example.resources.General;
import com.example.resources.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    private static String url = "http://api.weatherapi.com/v1/current.json?key=6a5bfb7354774e43b1c105914200911&q=";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{q}")
    public General getTemps(@PathVariable("q") String q){

        url = url + q;
        General general = restTemplate.getForObject(url, General.class);
        Current current = restTemplate.getForObject(url, Current.class);
        Location location = restTemplate.getForObject(url, Location.class);


        assert general != null;
        assert current != null;
        general.setCurrent(current);
        general.setLocation(location);


        return general;




    }

}
