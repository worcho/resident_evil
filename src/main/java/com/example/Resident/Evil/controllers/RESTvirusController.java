package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.repositories.VirusRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RESTVirusController {

    private final VirusRepository virusRepository;

    public RESTVirusController(VirusRepository virusRepository) {
        this.virusRepository = virusRepository;
    }

    @GetMapping("/showViruses")
    public List<Virus> showVirus() {
        return this.virusRepository.findAll();
    }
}
