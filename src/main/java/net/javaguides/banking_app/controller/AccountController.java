package net.javaguides.banking_app.controller;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
      // Add Deposit REST API
    @PutMapping("/{id}/deposit")
     public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
         double amount=request.get("amount");
          AccountDto accountDto=accountService.deposit(id,amount);
          return ResponseEntity.ok(accountDto);
     }
       //  Add withdraw REST API
     @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw( @PathVariable Long  id, @RequestBody Map<String,Double> request){

        double amount=request.get("amount");
         AccountDto accountDto=accountService.withdraw(id,amount);
         return ResponseEntity.ok(accountDto);
     }
      //   Get All Account REST API
     @GetMapping
     public ResponseEntity<List<AccountDto>> getAllAccount(){
         List<AccountDto> accounts =accountService.getAllAccount();
         return ResponseEntity.ok(accounts);

     }
}
