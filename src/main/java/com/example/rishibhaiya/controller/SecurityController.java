package com.example.rishibhaiya.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/security")
@CrossOrigin
public class SecurityController {

    @GetMapping
    public String baseUrl(){
        return "Base api";
    }

    @GetMapping("/users")
    public String semiBaseUrl(){
        return "Users and Admins can view";
    }

    @GetMapping("/admin")
    public String onlyAdminUrl(){
        return "Only Admin can view.";
    }
}
