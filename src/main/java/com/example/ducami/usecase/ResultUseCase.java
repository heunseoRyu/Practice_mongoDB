package com.example.ducami.usecase;

import com.example.ducami.dto.StudentScore;
import com.example.ducami.entity.Result;
import com.example.ducami.result.ResultAlreadyExistsException;
import com.example.ducami.service.ResultService;
import com.example.ducami.service.UserService;
import com.example.ducami.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

        // 2. 최초 저장하는 시험인지 확인
        if(resultService.checkIsValidTest(file.getOriginalFilename()))
            throw ResultAlreadyExistsException.EXCEPTION;

        // 2. result 저장
        resultService.saveExcel(file);
    }

    public List<Result> resultList() {
        return resultService.resultList();
    }

    public StudentScore getResult(String id, String password, String grade, String cls, String num, String name,Long fileId) {
        // 1. 유저 확인
        if(!userService.checkIsValidStudent(id,password,grade,cls,num,name))
            throw UserNotFoundException.EXCEPTION;

        // 3. fileId로 조회
        Result result = resultService.getFile(fileId);

        // 2. 성적 조회
        return resultService.getResult(grade,cls,num,result.getFileName());
    }
}
