package com.example.ducami.user;


import com.example.ducami.exception.BusinessException;
import com.example.ducami.user.error.UserErrorProperty;


public class UserNotFoundException extends BusinessException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
