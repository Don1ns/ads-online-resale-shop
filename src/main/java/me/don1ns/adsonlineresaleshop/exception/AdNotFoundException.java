package me.don1ns.adsonlineresaleshop.exception;

public class AdNotFoundException extends RuntimeException{
    public AdNotFoundException(String message) {
        super(message);
    }

    public AdNotFoundException() {
    }
}
