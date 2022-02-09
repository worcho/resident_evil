package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.User;
import com.example.Resident.Evil.models.binding.EditUserBindingModel;
import com.example.Resident.Evil.models.binding.RegisterUserBindingModel;
import com.example.Resident.Evil.models.service.UserServiceModel;
import com.example.Resident.Evil.models.view.UserViewModel;
import com.example.Resident.Evil.repositories.UserRepository;
import com.example.Resident.Evil.serivices.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    ModelAndView register(ModelAndView modelAndView, RegisterUserBindingModel registerUserBindingModel){
        modelAndView.setViewName("register");
        modelAndView.addObject("registerUserBindingModel", registerUserBindingModel);
        return modelAndView;
    }

    @PostMapping("/register")
    ModelAndView register(ModelAndView modelAndView, @Valid @ModelAttribute RegisterUserBindingModel registerUserBindingModel, BindingResult result){
        if (result.hasErrors()){
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.setViewName("register");
            return modelAndView1;
        }
        if (!userService.passwordMatch(registerUserBindingModel)){
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.addObject("passwordMatch", "Passwords do not match!");
            modelAndView1.setViewName("register");
            return modelAndView1;
        }else {
            userService.registerUser(modelMapper.map(registerUserBindingModel, UserServiceModel.class));
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

    }
    @GetMapping("/users")
    ModelAndView users(ModelAndView modelAndView){
        List <UserViewModel> viewModel = userService.getAllUsers()
                .stream()
                .map(u -> modelMapper.map(u, UserViewModel.class))
                .collect(Collectors.toList());
        modelAndView.setViewName("users");
        modelAndView.addObject("users", viewModel);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    ModelAndView register(@PathVariable Long id, EditUserBindingModel editUserBindingModel, ModelAndView modelAndView){
        userService.editUser(id, modelMapper.map(editUserBindingModel,UserServiceModel.class));
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, ModelAndView modelAndView) {
        userService.deleteUser(id);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

}
