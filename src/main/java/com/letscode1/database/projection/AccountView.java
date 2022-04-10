package com.letscode1.database.projection;

import com.letscode1.database.model.AccountType;
import com.letscode1.database.model.TransactionType;
import org.springframework.beans.factory.annotation.Value;

public interface AccountView {
  Integer getBalance();

  AccountType getAccountType();

  @Value("#{target.number + '-' + target.agency}")
  String getNumberAgency();

  UserView getUser();
}
