package me.dri.restproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class attributeAlreadyExists extends RuntimeException {

    public attributeAlreadyExists(String msg) {
        super(msg);
    }




}
