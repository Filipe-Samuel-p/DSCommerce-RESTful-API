package com.filipe.projectSpring.service.exceptions;


public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String msg) {
        super(msg);
    }
}
