package org.example.demoapi.exeption;

public class WrongOperationException extends RuntimeException {
    public WrongOperationException(String message) {
        super(message);
    }
}
