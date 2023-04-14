package com.sample.user.domain.exceptions;

public class UserServiceException extends RuntimeException {

    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }
}
