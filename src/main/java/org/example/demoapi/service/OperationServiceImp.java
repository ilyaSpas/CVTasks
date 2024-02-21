package org.example.demoapi.service;

import org.example.demoapi.controller.dto.OperationDto;
import org.example.demoapi.exeption.InsufficientFundsException;
import org.example.demoapi.exeption.WrongTypeOperationException;
import org.example.demoapi.model.Wallet;
import org.example.demoapi.service.imp.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationServiceImp implements OperationService {

    @Autowired
    private WalletServiceImp walletServiceImp;

    @Transactional
    @Override
    public Wallet executeOperation(OperationDto operationDto) {
        Wallet wallet = walletServiceImp.findByUUID(operationDto.getWalletId());
        switch (operationDto.getOperationType()) {
            case "DEPOSIT":
                if (Integer.parseInt(operationDto.getAmount()) < 0) {
                    if (wallet.getAmount() - Math.abs(Integer.parseInt(operationDto.getAmount())) < 0) {
                        throw new InsufficientFundsException("Insufficient funds in the account");
                    }
                }
                wallet.setAmount(wallet.getAmount() + Integer.parseInt(operationDto.getAmount()));
                break;
            case "WITHDRAW":
                wallet.setAmount(wallet.getAmount() + Integer.parseInt(operationDto.getAmount()));
                break;
            default:
                throw new WrongTypeOperationException("Wrong type of operation");
        }
        walletServiceImp.update(wallet);
        return wallet;
    }
}
