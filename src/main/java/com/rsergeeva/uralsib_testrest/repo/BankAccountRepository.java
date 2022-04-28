package com.rsergeeva.uralsib_testrest.repo;

import com.rsergeeva.uralsib_testrest.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
