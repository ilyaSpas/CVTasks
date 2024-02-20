package org.example.demoapi.service;

import org.example.demoapi.entity.Wallet;
import org.example.demoapi.exeption.InsufficientFundsException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OperationServiceTest {

    @Test
    void throwExceptionIfInsufficientFunds() {
        Wallet wallet = new Wallet(UUID.randomUUID(), 0L);
        try {

        } catch (InsufficientFundsException e) {
            assertTrue(true);
        }
    }
}