package com.example.ducami.usecase;

import com.example.ducami.service.ResultService;
import com.example.ducami.service.UserService;
import com.example.ducami.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ResultUseCase {

    private final ResultService resultService;
    private final UserService userService;

    public void postResult(String adminId, String password, MultipartFile file) {
        // 1. admin 비번 확인
        if(!userService.checkIsValidAdmin(adminId,password))
            throw UserNotFoundException.EXCEPTION;
        // 2. result 저장
        resultService.saveExcel(file);
    }
}
