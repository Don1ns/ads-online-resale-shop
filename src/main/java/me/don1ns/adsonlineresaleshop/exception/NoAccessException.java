package me.don1ns.adsonlineresaleshop.exception;

public class NoAccessException extends RuntimeException {
    public NoAccessException(String message) {
        super(message);
    }

    public NoAccessException() {
    }
}
