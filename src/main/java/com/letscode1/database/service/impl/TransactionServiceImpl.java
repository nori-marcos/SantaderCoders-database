package com.letscode1.database.service.impl;

import com.letscode1.database.DTO.request.TransactionRequest;
import com.letscode1.database.model.Transaction;
import com.letscode1.database.model.TransactionType;
import com.letscode1.database.projection.TransactionView;
import com.letscode1.database.repository.AccountRepository;
import com.letscode1.database.repository.TransactionRepository;
import com.letscode1.database.service.AccountService;
import com.letscode1.database.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired TransactionRepository transactionRepository;

  @Autowired AccountService accountService;

  @Autowired AccountRepository accountRepository;

  @Override
  public Transaction create(TransactionRequest transactionRequest, String cpf) {

    var account =
        accountRepository.findByUser_CpfAndNumberAndAgency(
            cpf, transactionRequest.getNumber(), transactionRequest.getAgency());

    Transaction transaction = new Transaction();
    transaction.setTransactionValue(transactionRequest.getTransactionValue());
    transaction.setTransactionType(transactionRequest.getTransactionType());
    transaction.setAgency(transactionRequest.getAgency());
    transaction.setNumber(transactionRequest.getNumber());
    transaction.setAccount(account);

    transaction =  transactionRepository.save(transaction);

    return transaction;
  }

  @Override
  public List<TransactionView> getAllViewByTransactionType(TransactionType transactionType) {
    return transactionRepository.findAllByTransactionType(transactionType);
  }
}
