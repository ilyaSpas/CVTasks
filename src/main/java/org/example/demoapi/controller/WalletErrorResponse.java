package org.example.demoapi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class WalletErrorResponse {

    private String msg;

    private LocalDateTime localDateTime;
}
