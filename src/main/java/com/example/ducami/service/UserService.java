package com.example.ducami.service;

import com.example.ducami.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.ducami.entity.UserType.ADMIN;
import static com.example.ducami.entity.UserType.STUDENT;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public boolean checkIsValidAdmin(String adminId, String password) {
        return userRepository.existsByUsernameAndPasswordAndAuthority(adminId,password, ADMIN);
    }

    public boolean checkIsValidStudent(String id, String password, String grade, String cls, String num, String name) {
        return userRepository.existsByUsernameAndPasswordAndAuthorityAndGradeAndClsAndNumAndName(id,password,STUDENT,Integer.valueOf(grade),Integer.valueOf(cls),Integer.valueOf(num),name);
    }
}
