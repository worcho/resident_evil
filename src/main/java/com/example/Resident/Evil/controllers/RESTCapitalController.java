package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.models.service.CapitalServiceModel;
import com.example.Resident.Evil.repositories.CapitalRepository;
import com.example.Resident.Evil.serivices.CapitalService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTCapitalController {

    private final CapitalService capitalService;

    public RESTCapitalController(CapitalService capitalService) {
        this.capitalService = capitalService;
    }

    @GetMapping("/showCapitals")
    public List<CapitalServiceModel> showVirus2() {
        return this.capitalService.getAllCapitals();
    }
}
