package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.repositories.CapitalRepository;
import com.example.Resident.Evil.serivices.CapitalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTCapitalController {

    private final CapitalService capitalService;
    private final CapitalRepository capitalRepository;

    public RESTCapitalController(CapitalService capitalService, CapitalRepository capitalRepository) {
        this.capitalService = capitalService;
        this.capitalRepository = capitalRepository;
    }


    @GetMapping("/showCapitals")
    public List<Capital> showVirus() {
        return this.capitalRepository.findAll();
    }

}
