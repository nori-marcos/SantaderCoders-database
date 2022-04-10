package com.letscode1.database.service;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;
import com.letscode1.database.model.AccountType;
import com.letscode1.database.projection.AccountView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
  Account create(AccountRequest accountRequest, Integer userId);

  Account update(AccountRequest accountRequest, String cpf);

  Page<Account> getAll(String cpf, int page, int size);

  Account getById(Integer id);

  void delete(Integer id);

  Account getByName(String name);

  List<AccountView> getAllViewByAccountType(AccountType accountType);
}
