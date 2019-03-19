package com.example.Akinator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {

    @GetMapping("/page")
    public String getIndex(){
        return "home.html";
    }

}
