package org.example.demoapi.controller;

import org.example.demoapi.entity.Wallet;
import org.example.demoapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/wallets/new")
    public ResponseEntity<Wallet> createWallet(){
        return new ResponseEntity<>(walletService.createWallet() ,HttpStatus.CREATED);
    }

    @GetMapping("/wallets/{wallet_UUID}")
    public ResponseEntity<Wallet> showWallet(@PathVariable("wallet_UUID")String uuid){
        return new ResponseEntity<>(walletService.findByUUID(uuid) ,HttpStatus.CREATED);
    }
}
