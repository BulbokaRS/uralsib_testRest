package com.rsergeeva.uralsib_testrest.controller;

import com.rsergeeva.uralsib_testrest.model.BankAccount;
import com.rsergeeva.uralsib_testrest.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/acc")
public class BAController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BAController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/info/{id}")
    public BankAccount getOneAcc(@PathVariable long id) {
        return bankAccountService.getAccount(id);
    }

    @GetMapping("/info/all")
    public List<BankAccount> getAccounts() {
        return bankAccountService.getAll();
    }

    @GetMapping("/{id}/{sum}")
    public ResponseEntity<BankAccount> takeMoney(@PathVariable("id") long id, @PathVariable("sum") double sum) {
        bankAccountService.downBalance(id, sum);
        return new ResponseEntity<>(bankAccountService.getAccount(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/{sum}")
    public ResponseEntity<BankAccount> giveMoney(@PathVariable("id") long id, @PathVariable("sum") double sum) {
        bankAccountService.upBalance(id, sum);
        return new ResponseEntity<>(bankAccountService.getAccount(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/send/{ids}/keep/{idk}/sum/{sum}")
    public ResponseEntity<List<BankAccount>> transferMoney
            (@PathVariable("ids") long ids, @PathVariable("idk") long idk, @PathVariable("sum") double sum) {
        bankAccountService.transferPay(ids, sum, idk);
        List<BankAccount> list = new ArrayList<>();
        list.add(bankAccountService.getAccount(ids));
        list.add(bankAccountService.getAccount(idk));
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

}
