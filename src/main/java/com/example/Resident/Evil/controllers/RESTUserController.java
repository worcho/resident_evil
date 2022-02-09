package com.example.Resident.Evil.controllers;

import com.example.Resident.Evil.models.service.UserServiceModel;
import com.example.Resident.Evil.repositories.UserRepository;
import com.example.Resident.Evil.serivices.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTUserController {

    private final UserService userService;

    public RESTUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/searchedUser/{username}")
    public UserServiceModel searchedUser(@PathVariable String username) {
        return this.userService.searchedByUsername(username);
    }
}
