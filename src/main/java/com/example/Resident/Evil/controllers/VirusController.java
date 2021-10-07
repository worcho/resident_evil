package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.models.binding.AddVirusBindingModel;
import com.example.Resident.Evil.repositories.CapitalRepository;
import com.example.Resident.Evil.repositories.VirusRepository;
import com.example.Resident.Evil.serivices.CapitalService;
import com.example.Resident.Evil.serivices.VirusService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class VirusController {

    private final CapitalService capitalService;
    private final CapitalRepository capitalRepository;
    private final VirusRepository virusRepository;
    private final VirusService virusService;
    Long virusesId;

    public VirusController(CapitalService capitalService, CapitalRepository capitalRepository, VirusRepository virusRepository, VirusService virusService) {
        this.capitalService = capitalService;
        this.capitalRepository = capitalRepository;
        this.virusRepository = virusRepository;
        this.virusService = virusService;
    }

    @GetMapping("/add")
    public ModelAndView addVirus(ModelAndView modelAndView, AddVirusBindingModel addVirusBindingModel) {
        modelAndView.setViewName("Add-virus");
        modelAndView.addObject("addVirusBindingModel",addVirusBindingModel);
        modelAndView.addObject("caps", capitalService.getAllCapitalsNames());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addVirus(@Valid @ModelAttribute AddVirusBindingModel addVirusBindingModel, BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()){
            return new ModelAndView("Add-virus");
        }
        virusRepository.save(virusService.getVirusFromForm(addVirusBindingModel));
        Long virusId = virusRepository.getIdByName(addVirusBindingModel.getName());
        virusService.saveMany(virusId, addVirusBindingModel);
        modelAndView.setViewName("redirect:/show");
        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView showVirus(ModelAndView modelAndView) {
        modelAndView.addObject("viruses", virusRepository.findAll());
        modelAndView.setViewName("Show-viruses");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editVirus(@PathVariable Long id, ModelAndView modelAndView, AddVirusBindingModel addVirusBindingModel) {
        virusesId = id;
        modelAndView.addObject("virusInfo",virusRepository.getById(virusesId));
        modelAndView.addObject("addVirusBindingModel",addVirusBindingModel);
        modelAndView.setViewName("Edit-virus");
        return modelAndView;
    }


    @PostMapping("/edit")
    public ModelAndView editVirusPost(@Valid AddVirusBindingModel addVirusBindingModel, BindingResult result, ModelAndView modelAndView) {

        if (result.hasErrors()){
            modelAndView.addObject("effect" , addVirusBindingModel.getSideEffects());
            return new ModelAndView("Edit-virus");
        }
        virusService.editVirus(virusesId, addVirusBindingModel);
        modelAndView.setViewName("redirect:/show");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, ModelAndView modelAndView) {
        virusRepository.deleteById(id);
        modelAndView.setViewName("redirect:/show");
        return modelAndView;
    }

}
