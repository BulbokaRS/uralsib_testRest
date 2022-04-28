package com.rsergeeva.uralsib_testrest.service.impl;

import com.rsergeeva.uralsib_testrest.model.BankAccount;
import com.rsergeeva.uralsib_testrest.repo.BankAccountRepository;
import com.rsergeeva.uralsib_testrest.service.BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount getAccount(Long id) {
        return bankAccountRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("Account with %d id not found", id)));
    }

    @Override
    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }

    @Transactional
    @Override
    public void setAccount(BankAccount account) {
        bankAccountRepository.save(account);
    }

    @Override
    @Transactional
    public void upBalance(long id, double inCash) {
        BankAccount bc = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Счет не найден"));
        bc.setBalance(bc.getBalance() + inCash);
    }

    @Override
    @Transactional
    public void downBalance(long id, double outCash) {
        BankAccount bc = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Счет не найден"));
        if (bc.getBalance() - outCash < 0) {
            throw new RuntimeException("На счету недостаточно средств для перевода");
        }
        bc.setBalance(bc.getBalance() - outCash);
    }

    @Override
    @Transactional
    public void transferPay(long sender, double outCash, long keeper) {
        downBalance(sender, outCash);
        upBalance(keeper, outCash);
    }
}
