package org.example.demoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

    private UUID walletId;

    private OperationType operationType;

    private Long amount;
}
