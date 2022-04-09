package com.letscode1.database.service.impl;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;
import com.letscode1.database.model.User;
import com.letscode1.database.repository.AccountRepository;
import com.letscode1.database.repository.UserRepository;
import com.letscode1.database.service.AccountService;
import com.letscode1.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired AccountRepository accountRepository;

  @Autowired UserService userService;

  @Autowired UserRepository userRepository;

  @Override
  public Account create(AccountRequest accountRequest, Integer userId) {
    var user = userService.getById(userId);

    Account account = new Account();
    account.setNumber(accountRequest.getNumber());
    account.setAccountType(accountRequest.getAccountType());
    account.setBalance(accountRequest.getBalance());
    account.setAgency(accountRequest.getAgency());
    account.setUser(user);

    account = accountRepository.save(account);

    return account;
  }

  @Override
  public Account update(AccountRequest accountRequest, String cpf) {

    Account account = accountRepository.findByCpf(cpf);

    account.setNumber(accountRequest.getNumber());
    account.setAccountType(accountRequest.getAccountType());
    account.setBalance(accountRequest.getBalance());
    account.setAgency(accountRequest.getAgency());

    account = accountRepository.save(account);

    return account;
  }

  @Override
  public List<Account> getAll(String cpf) {
    if (cpf != null) {
      User user = userRepository.findByCpf(cpf);
      return accountRepository.findByUser(user);
    } else {
      return accountRepository.findAll();
    }
  }

  @Override
  public Account getById(Integer id) {
    return accountRepository.findById(id).orElseThrow();
  }

  @Override
  public void delete(Integer id) {
    var account = accountRepository.findById(id).orElseThrow();
    accountRepository.delete(account);
  }

}
