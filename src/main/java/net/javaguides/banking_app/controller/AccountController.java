package net.javaguides.banking_app.controller;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
     // Add Post Rest API
    @PostMapping
     public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
          return new   ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
     }
      // Add Get Rest API
    @GetMapping("/{id}")
     public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
         AccountDto accountDto=accountService.getAccountById(id);
           return  ResponseEntity.ok(accountDto);
     }
}
