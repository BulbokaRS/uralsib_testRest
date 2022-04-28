package com.rsergeeva.uralsib_testrest.service;

import com.rsergeeva.uralsib_testrest.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount getAccount(Long id);
    List<BankAccount> getAll();
    void setAccount(BankAccount account);
    void upBalance(long id, double inCash);
    void downBalance(long id, double outCash);
    void transferPay(long sender, double outCash, long keeper);
}
