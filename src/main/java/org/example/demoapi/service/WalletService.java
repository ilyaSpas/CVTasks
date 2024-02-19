package org.example.demoapi.service;

import org.example.demoapi.entity.Wallet;
import org.example.demoapi.exeption.WalletNotFoundException;
import org.example.demoapi.model.Operation;
import org.example.demoapi.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(){
        return walletRepository.save(new Wallet());
    }

    public Wallet findByUUID(String uuid) {
        try {
            return walletRepository.findById(UUID.fromString(uuid))
                    .orElseThrow(WalletNotFoundException::new);
        } catch (IllegalArgumentException e){
            throw new WalletNotFoundException();
        }
    }

    public Wallet update(Wallet wallet){
        return walletRepository.save(wallet);
    }
}
