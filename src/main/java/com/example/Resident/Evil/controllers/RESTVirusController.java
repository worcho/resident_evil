package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.models.service.VirusServiceModel;
import com.example.Resident.Evil.repositories.VirusRepository;
import com.example.Resident.Evil.serivices.VirusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTVirusController {

    private final VirusService virusService;

    public RESTVirusController(VirusService virusService) {
        this.virusService = virusService;
    }

    @GetMapping("/showViruses")
    public List<VirusServiceModel> showVirus() {
        return this.virusService.getAllViruses();
    }
}
