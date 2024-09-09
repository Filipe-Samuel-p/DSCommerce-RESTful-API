package com.filipe.projectSpring.resources.exceptions;

import com.filipe.projectSpring.services.exceptions.DataBaseException;
import com.filipe.projectSpring.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //esta falando que o método vai interceptar qualquer exceção do tipo ResourceNotFoundException e vai fazer o tratamento definido dentro da funcao
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource no found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(e.getMessage(),
                error,
                request.getRequestURI(),
                status.value(),
                Instant.now());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> resourceNotFound(DataBaseException e, HttpServletRequest request){
        String error = "DataBase error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(e.getMessage(),
                error,
                request.getRequestURI(),
                status.value(),
                Instant.now());
        return ResponseEntity.status(status).body(err);
    }


}
