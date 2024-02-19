package org.example.demoapi.service;

import org.example.demoapi.dto.OperationDto;
import org.example.demoapi.entity.Wallet;
import org.example.demoapi.exeption.InsufficientFundsException;
import org.example.demoapi.exeption.WrongTypeOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationService {

    @Autowired
    private WalletService walletService;

    @Transactional
    public Wallet executeOperation(OperationDto operationDto) {
        Wallet wallet = walletService.findByUUID(operationDto.getWalletId());
        switch (operationDto.getOperationType()) {
            case "DEPOSIT":
                if (Integer.parseInt(operationDto.getAmount()) < 0){
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
        walletService.update(wallet);
        return wallet;
    }
}
