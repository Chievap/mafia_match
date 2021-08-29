package com.example.Mafia_Match.repositories;

import com.example.Mafia_Match.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findByIdAccount(long idAccount);

    @Transactional
    Optional<Boolean> deleteAccountByIdAccount(long idAccount);
}
