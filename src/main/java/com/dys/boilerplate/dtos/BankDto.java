package com.dys.boilerplate.dtos;

public class BankDto {
    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public BankDto setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    @Override
    public String toString() {
        return "BankDto{" +
                "bankName='" + bankName + '\'' +
                '}';
    }
}
