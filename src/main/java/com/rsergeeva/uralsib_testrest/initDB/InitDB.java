package com.rsergeeva.uralsib_testrest.initDB;

import com.rsergeeva.uralsib_testrest.model.BankAccount;
import com.rsergeeva.uralsib_testrest.service.BankAccountService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class InitDB {

    private final BankAccountService bankAccountService;

    public InitDB(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostConstruct
    private void initDB() {
        BankAccount bc1 = new BankAccount("125436897845121", 250.00);
        BankAccount bc2 = new BankAccount("123456789665655", 380.25);
        BankAccount bc3 = new BankAccount("556989845462232", 1558.25);
        bankAccountService.setAccount(bc1);
        bankAccountService.setAccount(bc2);
        bankAccountService.setAccount(bc3);
        BankAccount bc4 = new BankAccount("158546755316664", 2558.02);
        BankAccount bc5 = new BankAccount("124754888211123", 100.00);
        BankAccount bc6 = new BankAccount("52515545213321", 188.21);
        bankAccountService.setAccount(bc4);
        bankAccountService.setAccount(bc5);
        bankAccountService.setAccount(bc6);
    }


}
