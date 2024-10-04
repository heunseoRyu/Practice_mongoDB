package com.example.ducami.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {
    STUDENT("STUDENT"),
    ADMIN("ADMIN");

    private final String authority;
}
