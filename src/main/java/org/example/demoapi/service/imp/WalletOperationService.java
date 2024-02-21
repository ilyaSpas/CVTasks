package org.example.demoapi.service.imp;

import org.example.demoapi.controller.dto.OperationDto;
import org.example.demoapi.model.Wallet;

public interface WalletOperationService {

    Wallet executeOperation(OperationDto operationDto);
}
