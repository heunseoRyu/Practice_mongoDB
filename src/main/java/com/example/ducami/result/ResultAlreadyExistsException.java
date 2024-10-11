package com.example.ducami.result;


import com.example.ducami.exception.BusinessException;
import com.example.ducami.result.error.ResultErrorProperty;


public class ResultAlreadyExistsException extends BusinessException {
    public static final ResultAlreadyExistsException EXCEPTION = new ResultAlreadyExistsException();

    private ResultAlreadyExistsException() {
        super(ResultErrorProperty.RESULT_EXISTS);
    }
}
