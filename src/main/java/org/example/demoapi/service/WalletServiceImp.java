package org.example.demoapi.service;

import org.example.demoapi.exeption.WalletNotFoundException;
import org.example.demoapi.model.Wallet;
import org.example.demoapi.repository.WalletRepository;
import org.example.demoapi.service.imp.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletServiceImp implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet createWallet() {
        return walletRepository.save(new Wallet());
    }

    @Override
    public Wallet findByUUID(String uuid) {
        try {
            return walletRepository.findById(UUID.fromString(uuid))
                    .orElseThrow(WalletNotFoundException::new);
        } catch (IllegalArgumentException e) {
            throw new WalletNotFoundException();
        }
    }

    @Override
    public Wallet update(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}
