package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.serivices.VirusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

    private final VirusService virusService;

    public MapController(VirusService virusService) {
        this.virusService = virusService;
    }

    @GetMapping("/map")
    public ModelAndView map(){
        String geoJson = virusService.getMap();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("map");
        modelAndView.addObject("geoJson",geoJson);
        return modelAndView;
    }
}
