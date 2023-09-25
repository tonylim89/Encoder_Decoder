package com.example;

public class InvalidOffsetException extends RuntimeException {
    public InvalidOffsetException(String message) {
        super(message);
    }
}