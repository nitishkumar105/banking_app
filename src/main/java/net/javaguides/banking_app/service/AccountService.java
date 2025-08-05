package net.javaguides.banking_app.service;
import net.javaguides.banking_app.dto.AccountDto;

public interface AccountService {
      AccountDto createAccount(AccountDto accountDto);
       AccountDto getAccountById(Long id);
       AccountDto deposit(Long id,double amount);
       AccountDto withdraw(Long id,double amount);
}
