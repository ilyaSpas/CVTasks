package org.example.demoapi.service.imp;

import org.example.demoapi.model.Wallet;


public interface WalletService {
    public Wallet createWallet();

    public Wallet findByUUID(String uuid);

    public Wallet update(Wallet wallet);
}
