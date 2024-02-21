package org.example.demoapi.service.imp;

import org.example.demoapi.controller.dto.OperationDto;
import org.example.demoapi.model.Wallet;

public interface OperationService {

    Wallet executeOperation(OperationDto operationDto);
}
