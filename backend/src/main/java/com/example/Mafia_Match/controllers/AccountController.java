package com.example.Mafia_Match.controllers;

import com.example.Mafia_Match.dao.Account;
import com.example.Mafia_Match.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v0/account")
@Tag(name = "Accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(description = "Get account by id")
    @GetMapping(path = "/{idAccount}")
    public ResponseEntity<?> getAccount(@PathVariable long idAccount) {
        Account account = accountService.getAccountById(idAccount);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(description = "Create an account")
    @PostMapping(path = "/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.createAccount(account);
        if (savedAccount != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(description = "Delete an account")
    @DeleteMapping(path = "/{idAccount}")
    public ResponseEntity<?> deleteAccount(@PathVariable long idAccount) {
        return new ResponseEntity<>(true, accountService.deleteAccount(idAccount));
    }
}
