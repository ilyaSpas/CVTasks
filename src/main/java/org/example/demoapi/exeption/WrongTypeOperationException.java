package org.example.demoapi.exeption;

public class WrongTypeOperationException extends RuntimeException {
    public WrongTypeOperationException(String message) {
        super(message);
    }
}
