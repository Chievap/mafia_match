package com.example.Mafia_Match.service;

import com.example.Mafia_Match.dao.Account;
import com.example.Mafia_Match.repositories.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(long id) {
        Optional<Account> account = accountRepository.findByIdAccount(id);
        return account.orElse(null);
    }

    public HttpStatus deleteAccount(long id){
        Optional<Account> account = accountRepository.findByIdAccount(id);
        if(account.isPresent()){
            Optional<Boolean> success = accountRepository.deleteAccountByIdAccount(account.get().getIdAccount());
            if(success.isPresent()){
                return HttpStatus.OK;
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
