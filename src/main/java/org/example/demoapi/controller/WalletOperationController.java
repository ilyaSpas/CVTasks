package org.example.demoapi.controller;

import jakarta.validation.Valid;
import org.example.demoapi.controller.dto.OperationDto;
import org.example.demoapi.exeption.WrongOperationException;
import org.example.demoapi.model.Wallet;
import org.example.demoapi.service.WalletWalletOperationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WalletOperationController {

    @Autowired
    private WalletWalletOperationServiceImp walletOperationServiceImp;

    @PostMapping("/wallet")
    public ResponseEntity<Wallet> executeOperation(@RequestBody
                                                   @Valid
                                                       OperationDto operationDto,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                sb.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new WrongOperationException(sb.toString());
        }
        return new ResponseEntity<>(walletOperationServiceImp.executeOperation(operationDto), HttpStatus.OK);
    }
}
