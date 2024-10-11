package com.example.ducami.user.error;


import com.example.ducami.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorProperty implements ErrorProperty {
    USER_CONFLICT(HttpStatus.CONFLICT, "유저 아이디가 이미 존재합니다."),
    PASSWORD_WRONG(HttpStatus.BAD_REQUEST, "비밀번호가 맞지 않습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "정보가 일치하는 유저를 찾을 수 없습니다"),
    WITHDRAW_FAILED(HttpStatus.BAD_REQUEST,"회원탈퇴 중 에러가 발생했습니다.");

    private final HttpStatus status;
    private final String message;
}
