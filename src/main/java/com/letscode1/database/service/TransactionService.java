package com.letscode1.database.service;

import com.letscode1.database.DTO.request.TransactionRequest;
import com.letscode1.database.model.Transaction;
import com.letscode1.database.model.TransactionType;
import com.letscode1.database.projection.TransactionView;

import java.util.List;

public interface TransactionService {
    Transaction create(TransactionRequest transactionRequest, String cpf);

//    List<TransactionView> getAllViewByAccountUserCpf(String cpf);

    List<TransactionView> getAllViewByTransactionType(TransactionType transactionType);
}
