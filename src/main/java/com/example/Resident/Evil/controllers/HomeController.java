package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.models.service.CapitalServiceModel;
import com.example.Resident.Evil.serivices.CapitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final CapitalService capitalService;

    public HomeController(CapitalService capitalService) {
        this.capitalService = capitalService;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("capitals",capitalService.getAllCapitals());
        return modelAndView;
    }
}
