package org.example.demoapi.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class WalletErrorResponse {

    private String msg;

    private LocalDateTime localDateTime;
}
