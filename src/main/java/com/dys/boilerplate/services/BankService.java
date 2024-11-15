package com.dys.boilerplate.services;

import com.dys.boilerplate.dtos.BankDto;
import com.dys.boilerplate.entities.Bank;
import com.dys.boilerplate.repositories.BankRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    public Bank store(BankDto input){
        var bank = new Bank();
        bank.setBankName(input.getBankName());

        return bankRepository.save(bank);
    }

    public List<Bank> allBank(){
        List<Bank> banks = new ArrayList<>();

        bankRepository.findAll().forEach(banks::add);

        return banks;
    }
}
