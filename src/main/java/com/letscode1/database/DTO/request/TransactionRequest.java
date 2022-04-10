package com.letscode1.database.DTO.request;

import com.letscode1.database.model.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionRequest {
  private BigDecimal transactionValue;
  private TransactionType transactionType;
  private Integer agency;
  private Integer number;
}
