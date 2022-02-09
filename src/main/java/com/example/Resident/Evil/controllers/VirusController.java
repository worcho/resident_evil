package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.Virus;
import com.example.Resident.Evil.models.binding.AddVirusBindingModel;
import com.example.Resident.Evil.models.binding.EditVirusBindingModel;
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
    private final VirusService virusService;
    private final ModelMapper modelMapper;
    Long virusesId;

    public VirusController(CapitalService capitalService, VirusRepository virusRepository, VirusService virusService, ModelMapper modelMapper) {
        this.capitalService = capitalService;
        this.virusService = virusService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/show")
    public ModelAndView showVirus(ModelAndView modelAndView) {
        modelAndView.setViewName("newShow");
        return modelAndView;
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
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.setViewName("Add-virus");
            modelAndView1.addObject("caps", capitalService.getAllCapitalsNames());
            modelAndView1.addObject("capsAfterError", addVirusBindingModel.getCapitals());
            return modelAndView1;
        }
        virusService.addVirus(modelMapper.map(addVirusBindingModel,VirusServiceModel.class));
        modelAndView.setViewName("redirect:/show");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editVirus(@PathVariable Long id, ModelAndView modelAndView) {
        VirusServiceModel viewModel = modelMapper.map(virusService.getVirusById(id), VirusServiceModel.class);
        modelAndView.setViewName("Edit-virus");
        virusesId = id;

        modelAndView.addObject("caps", virusService.findAllVirusCapitals(id));
        modelAndView.addObject("virusInput", viewModel);
        modelAndView.addObject("editVirusBindingModel",viewModel);
        if (viewModel.getIsDeadly().equals("Yes")){
            modelAndView.addObject("flag1", true);
        }
        if (viewModel.getIsCurable().equals("Yes")) {
            modelAndView.addObject("flag2", true);
        }
        
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editVirusPost(@Valid @ModelAttribute EditVirusBindingModel editVirusBindingModel ,BindingResult result, ModelAndView modelAndView, Model model) {
        if (result.hasErrors()){
            model.addAttribute("virusInput", editVirusBindingModel);
            return new ModelAndView("Edit-virus");
        }
        virusService.editVirus(virusesId, modelMapper.map(editVirusBindingModel,VirusServiceModel.class));
        modelAndView.setViewName("redirect:/show");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, ModelAndView modelAndView) {
        virusService.deleteVirus(id);
        modelAndView.setViewName("redirect:/show");
        return modelAndView;
    }

}
