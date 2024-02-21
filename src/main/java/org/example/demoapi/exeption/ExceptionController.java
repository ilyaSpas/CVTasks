package org.example.demoapi.exeption;

import org.example.demoapi.controller.WalletErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    private ResponseEntity<WalletErrorResponse> handleException(WalletNotFoundException e) {
        WalletErrorResponse response = new WalletErrorResponse("Wallet not found!", LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<WalletErrorResponse> handleException(WrongOperationException e) {
        WalletErrorResponse response = new WalletErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<WalletErrorResponse> handleException(WrongTypeOperationException e) {
        WalletErrorResponse response = new WalletErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<WalletErrorResponse> handleException(InsufficientFundsException e) {
        WalletErrorResponse response = new WalletErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<WalletErrorResponse> handleException(Exception e) {
        WalletErrorResponse response = new WalletErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
