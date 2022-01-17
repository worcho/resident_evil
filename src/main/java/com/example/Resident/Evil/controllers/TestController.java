package com.example.Resident.Evil.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/UNauth")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String authed(){
        return "UNauthed!";
    }

    @GetMapping("/auth")
    @ResponseBody
    public String unauthed(){
        return "auth!";
    }

    @GetMapping("/for_users")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String users(){
        return "I am authorized method for users!";
    }

    @GetMapping("/for_admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admins(){
        return "I am authorized method for admins!";
    }
}
