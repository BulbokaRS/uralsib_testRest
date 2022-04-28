package com.rsergeeva.uralsib_testrest.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account")
@Check(constraints = "BALANCE >= 0")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column (name = "balance", unique = true)
    private double balance;

    @Column (name = "number")
    private String number;

    public BankAccount() {
    }

    public BankAccount(String number, double balance) {
        this.balance = balance;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return getId() == that.getId() && Double.compare(that.getBalance(), getBalance()) == 0 && getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getNumber());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", number='" + number + '\'' +
                '}';
    }
}
