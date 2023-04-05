package com.groupware.exception;

//권한이 없을때 예외 처리
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }
}
