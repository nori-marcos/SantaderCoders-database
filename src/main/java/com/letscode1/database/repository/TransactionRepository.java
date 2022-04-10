package com.letscode1.database.repository;

import com.letscode1.database.model.Transaction;
import com.letscode1.database.model.TransactionType;
import com.letscode1.database.projection.TransactionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

  @Query("select t from Transaction t where (t.transactionType = :tipoDeTransacao)")
  List<TransactionView> findAllByTransactionType(@Param("tipoDeTransacao") TransactionType transactionType);
}
