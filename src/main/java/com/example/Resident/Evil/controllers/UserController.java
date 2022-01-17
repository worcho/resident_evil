package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.entities.User;
import com.example.Resident.Evil.models.binding.RegisterUserBindingModel;
import com.example.Resident.Evil.repositories.UserRepository;
import com.example.Resident.Evil.serivices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
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
            userService.registerUser(registerUserBindingModel);
            modelAndView.setViewName("register");
            return modelAndView;
        }

    }
    @GetMapping("/users")
    ModelAndView users(ModelAndView modelAndView){
        modelAndView.setViewName("users");
        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();
        modelAndView.addObject("users", userList);
        return modelAndView;
    }

/*
    @GetMapping("/login")
    ModelAndView login(ModelAndView modelAndView, RegisterUserBindingModel registerUserBindingModel){
        modelAndView.setViewName("login");
        modelAndView.addObject("registerUserBindingModel", registerUserBindingModel);
        return modelAndView;
    }

    @PostMapping("/login")
    ModelAndView loginPost(ModelAndView modelAndView, RegisterUserBindingModel registerUserBindingModel, HttpSession session){

        if (userService.loginUser(registerUserBindingModel)){
            session.setAttribute("name",registerUserBindingModel);
            System.out.println("Login");
        }else{
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.setViewName("login");
            modelAndView1.addObject("loginError", "Invalid Username or Password.");
            return modelAndView1;
        }
        modelAndView.setViewName("login");
        modelAndView.addObject("registerUserBindingModel", registerUserBindingModel);
        return modelAndView;
    }

 */
}
