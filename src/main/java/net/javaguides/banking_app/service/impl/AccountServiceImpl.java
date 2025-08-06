package net.javaguides.banking_app.service.impl;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.entity.Account;
import net.javaguides.banking_app.mapper.AccountMapper;
import net.javaguides.banking_app.repository.AccountRepository;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private final AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
          Account account= AccountMapper.mapToAccount(accountDto);
           Account savedAccount=accountRepository.save(account);
           return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("id is not existed"));
        return  AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
          Account account=accountRepository
                  .findById(id)
                  .orElseThrow(()-> new RuntimeException("Account not find"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));

          if(account.getBalance()<amount)
            throw new RuntimeException("withdraw amount is greater than available balance");

           double total=account.getBalance()-amount;
           account.setBalance(total);
           Account savedAccount=accountRepository.save(account);
               return AccountMapper.mapToAccountDto(savedAccount);



    }

    @Override
    public List<AccountDto> getAllAccount() {
          List<Account> accounts=accountRepository.findAll();
        return   accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
        //  return List.of();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account not find"));
          accountRepository.deleteById(id);
    }
}
