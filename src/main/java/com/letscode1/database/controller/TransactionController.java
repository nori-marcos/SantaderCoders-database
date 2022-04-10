package com.letscode1.database.controller;

import com.letscode1.database.DTO.request.TransactionRequest;
import com.letscode1.database.model.Transaction;
import com.letscode1.database.model.TransactionType;
import com.letscode1.database.projection.TransactionView;
import com.letscode1.database.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

  @Autowired TransactionService transactionService;

  @PostMapping
  public Transaction create(
      @RequestBody TransactionRequest transactionRequest,
      @RequestParam(required = true) String cpf) {
    return transactionService.create(transactionRequest, cpf);
  }

  //  retorna a view de transações
  @GetMapping("/view")
  public List<TransactionView> getAllTransactionViewByTransactionType(
      @RequestParam TransactionType transactionType) {
    return transactionService.getAllViewByTransactionType(transactionType);
  }
}
