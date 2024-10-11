package com.example.ducami.controller;

import com.example.ducami.usecase.ResultUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final ResultUseCase resultUseCase;

    @GetMapping("/upload")
    public String excel() {
        return "upload";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/select")
    public String result(Model model) {
        model.addAttribute("results", resultUseCase.resultList());
        return "select";
    }

}
