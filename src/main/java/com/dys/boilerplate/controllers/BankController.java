package com.dys.boilerplate.controllers;

import com.dys.boilerplate.dtos.BankDto;
import com.dys.boilerplate.entities.Bank;
import com.dys.boilerplate.services.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/banks")
@RestController
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @PostMapping("/store")
    public ResponseEntity<Bank> store(@RequestBody BankDto bankDto){
        Bank storeBank = bankService.store(bankDto);

        return ResponseEntity.ok(storeBank);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Bank>> allBanks(){
        List<Bank> banks = bankService.allBank();

        return ResponseEntity.ok(banks);
    }
}
