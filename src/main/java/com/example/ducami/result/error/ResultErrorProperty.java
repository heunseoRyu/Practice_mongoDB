package com.example.ducami.result.error;


import com.example.ducami.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResultErrorProperty implements ErrorProperty {
    RESULT_EXISTS(HttpStatus.CONFLICT, "이미 저장한 성적이 존재합니다");

    private final HttpStatus status;
    private final String message;
}
