package com.letscode1.database.service.impl;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;
import com.letscode1.database.repository.AccountRepository;
import com.letscode1.database.service.AccountService;
import com.letscode1.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserService userService;

    @Override
    public Account create(AccountRequest accountRequest, Integer userId) {
        var user = userService.getById(userId);

        Account account = new Account();
        account.setNumber(accountRequest.getNumber()) ;
        account.setAccountType(accountRequest.getAccountType());
        account.setBalance(accountRequest.getBalance());
        account.setAgency(accountRequest.getAgency());
        account.setUser(user);

        account = accountRepository.save(account);

        return account;
    }
}
