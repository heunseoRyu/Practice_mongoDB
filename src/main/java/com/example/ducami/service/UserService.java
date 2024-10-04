package com.example.ducami.service;

import com.example.ducami.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.ducami.entity.UserType.ADMIN;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public boolean checkIsValidAdmin(String adminId, String password) {
        return userRepository.existsByUsernameAndPasswordAndAuthority(adminId,password, ADMIN);
    }
}
