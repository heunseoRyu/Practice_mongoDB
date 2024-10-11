package com.example.ducami.controller;

import com.example.ducami.entity.Result;
import com.example.ducami.usecase.ResultUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultUseCase resultUseCase;

    @PostMapping("")
    public String postResult(@RequestParam("adminId") String adminId, @RequestParam("password") String password, @RequestParam("file") MultipartFile file){
        resultUseCase.postResult(adminId,password,file);
        return "home";
    }

    @GetMapping("/{id}")
    public String selectFile(
            @PathVariable("id") Long id,
            Model model
    ){
        model.addAttribute("fileId",id);
        return "writeInfo";
    }

    @GetMapping("/{id}/score")
    public String getResult(
                @PathVariable("id") Long id,
                @RequestParam("userId") String userId,
                @RequestParam("password") String password,
                @RequestParam("grade") String grade,
                @RequestParam("cls") String cls,
                @RequestParam("num") String num,
                @RequestParam("name") String name,
                Model model
    ){
        model.addAttribute("result",resultUseCase.getResult(userId,password,grade,cls,num,name,id));
        return "score";
    }

    @GetMapping("/list")
    public List<Result> resultList(){
        return resultUseCase.resultList();
    }
}
