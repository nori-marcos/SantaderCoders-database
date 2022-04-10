package com.letscode1.database.service.impl;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;
import com.letscode1.database.model.AccountType;
import com.letscode1.database.projection.AccountView;
import com.letscode1.database.repository.AccountRepository;
import com.letscode1.database.repository.UserRepository;
import com.letscode1.database.service.AccountService;
import com.letscode1.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
  public Page<Account> getAll(String name, int page, int size) {
    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");


    if (name != null) {
      return accountRepository.findByUser_Name(name, pageRequest);
    }
      return accountRepository.findAll(pageRequest);
  }

  @Override
  public Account getByName(String name) {
    return accountRepository.findByName(name);
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

  @Override
  public List<AccountView> getAllViewByAccountType(AccountType accountType){
    return accountRepository.findAllByAccountType(accountType);
  }

}
