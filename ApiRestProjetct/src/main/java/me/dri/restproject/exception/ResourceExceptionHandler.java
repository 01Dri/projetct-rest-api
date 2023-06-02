package me.dri.restproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundDb.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundDb e)  {
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse err = new ExceptionResponse(new Date(),  error, e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(attributeAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> attributeAlreadyExists(attributeAlreadyExists e)  {
        String error = "Attribute already exists";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse err = new ExceptionResponse(new Date(),  error, e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
    }
}
