package me.don1ns.adsonlineresaleshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdNotFoundException extends RuntimeException{
    public AdNotFoundException(String message) {
        super(message);
    }

    public AdNotFoundException() {
    }
}
