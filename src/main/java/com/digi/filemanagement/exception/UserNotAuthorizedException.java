package com.digi.filemanagement.exception;

public class UserNotAuthorizedException extends RuntimeException{

    public UserNotAuthorizedException(String message) {
        super(message);
    }
}
