package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.models.binding.AddVirusBindingModel;
import com.example.Resident.Evil.models.service.VirusServiceModel;
import com.example.Resident.Evil.repositories.CapitalRepository;
import com.example.Resident.Evil.repositories.VirusRepository;
import com.example.Resident.Evil.serivices.CapitalService;
import com.example.Resident.Evil.serivices.VirusService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class VirusController {

    private final CapitalService capitalService;
    private final CapitalRepository capitalRepository;
    private final VirusRepository virusRepository;
    private final VirusService virusService;
    private final ModelMapper modelMapper;
    Long virusesId;


    public VirusController(CapitalService capitalService, CapitalRepository capitalRepository, VirusRepository virusRepository, VirusService virusService, ModelMapper modelMapper) {
        this.capitalService = capitalService;
        this.capitalRepository = capitalRepository;
        this.virusRepository = virusRepository;
        this.virusService = virusService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView addVirus(ModelAndView modelAndView, AddVirusBindingModel addVirusBindingModel) {
        modelAndView.setViewName("Add-virus");
        modelAndView.addObject("addVirusBindingModel",addVirusBindingModel);
        modelAndView.addObject("caps", capitalService.getAllCapitalsNames());
        return modelAndView;

    }

    @PostMapping("/add")
    public ModelAndView addVirus(@Valid @ModelAttribute AddVirusBindingModel addVirusBindingModel, BindingResult result, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.setViewName("Add-virus");
            modelAndView1.addObject("caps", capitalService.getAllCapitalsNames());
            modelAndView1.addObject("capsAfterError", addVirusBindingModel.getCapitals());
            return modelAndView1;

        }
        virusRepository.save(virusService.getVirusFromForm(addVirusBindingModel));
        modelAndView.setViewName("redirect:/show");
        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView showVirus(ModelAndView modelAndView) {
        modelAndView.setViewName("newShow");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editVirus(@PathVariable Long id, ModelAndView modelAndView, AddVirusBindingModel addVirusBindingModel, Model model) {
        VirusServiceModel virusById = modelMapper.map(virusRepository.getById(id), VirusServiceModel.class);
        modelAndView.setViewName("Edit-virus");
        virusesId = id;

        if(!model.containsAttribute("virusInput")) {
            AddVirusBindingModel bindingModel = modelMapper.map(virusById, AddVirusBindingModel.class);
            model.addAttribute("caps", virusRepository.findAllVirusCapitals(virusesId));
            model.addAttribute("virusInput", bindingModel);
        }
        modelAndView.addObject("addVirusBindingModel",addVirusBindingModel);

        return modelAndView;
    }


    @PostMapping("/edit")
    public ModelAndView editVirusPost(@Valid @ModelAttribute AddVirusBindingModel addVirusBindingModel, BindingResult result, ModelAndView modelAndView, Model model) {

        if (result.hasErrors()){

            model.addAttribute("virusInput", addVirusBindingModel);
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
