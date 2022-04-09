package com.letscode1.database.repository;

import com.letscode1.database.model.Account;
import com.letscode1.database.model.AccountType;
import com.letscode1.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findByBalanceLessThan(BigDecimal balance);
    List<Account> findByBalanceLessThanEqual(BigDecimal balance);
    List<Account> findByBalanceGreaterThan(BigDecimal balance);
    List<Account> findByBalanceGreaterThanEqual(BigDecimal balance);

    List<Account> findByBalanceBetween(BigDecimal openingBalance, BigDecimal finalBalance);
    List<Account> findByBalanceIn(List<BigDecimal> balances);

    List<Account> findByAccountTypeAndBalanceBetweenOrderByBalance(AccountType accountType, BigDecimal openingBalance, BigDecimal finalBalance);

    List<Account> findByUser_cpf(String cpf);

    Boolean existsByAccountType(AccountType accountType);

    @Query("select c from Account c " +
            "where (c.accountType = :accountType and c.user.cpf = :cpf) " +
            "or (c.accountType = :accountType or c.balance = :saldo)")
    List<Account> findByAccountTypeAndCpfOrAccountTypeAndBalance(
            @Param("accountType") AccountType accountType,
            @Param("cpf") String cpf,
            @Param("saldo") BigDecimal balance
    );

    @Query(value = "select * from conta c" +
            "where (c.tipo_conta = :accountType AND" +
            "c.data_criacao >= :updateDate)" +
            "OR c.saldo = :balance ", nativeQuery = true)
    List<Account> findByDataCriacaoAndAccountTypeOrSaldo(
            @Param("dataCriacao") LocalDateTime updateDate,
            @Param("accountType") LocalDateTime accountType,
            @Param("saldo") BigDecimal balance
    );

    @Query("select c from Conta c " +
            "where c.tipoConta = :tipoConta and c.usuario.nome = :nome")
    List<Account> findByTipoContaAndUsuarioName(
//            @Param("tipoConta") TipoConta tipoConta,
            @Param("nome") String nome
    );

}
