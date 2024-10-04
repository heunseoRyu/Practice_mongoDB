package com.example.ducami.controller;

import com.example.ducami.usecase.ResultUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultUseCase resultUseCase;

    @PostMapping("")
    public String postResult(@RequestParam("adminId") String adminId,@RequestParam("password") String password,@RequestParam("file") MultipartFile file){
        resultUseCase.postResult(adminId,password,file);
        return "home";
    }
}
