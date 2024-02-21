package org.example.demoapi.controller;

import org.example.demoapi.model.Wallet;
import org.example.demoapi.service.WalletService;
import org.example.demoapi.service.imp.WalletServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    @Autowired
    private WalletService walletServiceImp;

    @PostMapping("/wallets/new")
    public ResponseEntity<Wallet> createWallet(){
        return new ResponseEntity<>(walletServiceImp.createWallet() ,HttpStatus.CREATED);
    }

    @GetMapping("/wallets/{wallet_UUID}")
    public ResponseEntity<Wallet> showWallet(@PathVariable("wallet_UUID")String uuid){
        return new ResponseEntity<>(walletServiceImp.findByUUID(uuid) ,HttpStatus.CREATED);
    }
}
