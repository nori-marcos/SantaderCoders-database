package com.letscode1.database.service;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;

import java.util.List;

public interface AccountService {
  Account create(AccountRequest accountRequest, Integer userId);

  Account update(AccountRequest accountRequest, String cpf);

  List<Account> getAll(String cpf);

  Account getById(Integer id);

  void delete(Integer id);
}
