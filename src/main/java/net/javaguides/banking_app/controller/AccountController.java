package net.javaguides.banking_app.controller;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
     // add rest API
    @PostMapping
     public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
          return new   ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
     }
}
