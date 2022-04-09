package com.letscode1.database.service;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;

public interface AccountService {
  Account create(AccountRequest accountRequest, Integer userId);
}
