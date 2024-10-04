package com.example.ducami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/upload")
    public String excel() {
        return "upload";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/select")
    public String result() {
        return "select";
    }

}
