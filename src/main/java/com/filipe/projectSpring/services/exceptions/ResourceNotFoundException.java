package com.filipe.projectSpring.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException { //Classe para tratar erro é uma subclasse da RuntimeException -> classe de exceção que o compilador não obriga a tratar

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id: " + id );
    }

}