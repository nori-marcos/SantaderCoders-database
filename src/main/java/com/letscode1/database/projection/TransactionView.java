package com.letscode1.database.projection;

import com.letscode1.database.model.TransactionType;

import java.time.LocalDateTime;

public interface TransactionView {
    Integer getTransactionValue();

    TransactionType getTransactionType();

    LocalDateTime getCreationDate();

    LocalDateTime getUpdateDate();
}
