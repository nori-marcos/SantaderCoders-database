package com.letscode1.database.DTO.request;

import com.letscode1.database.model.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountRequest {
  private Integer number;
  private AccountType accountType;
  private BigDecimal balance;
  private Integer agency;
}
