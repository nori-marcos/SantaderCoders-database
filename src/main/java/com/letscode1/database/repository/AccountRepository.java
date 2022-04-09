package com.letscode1.database.repository;

import com.letscode1.database.model.Account;
import com.letscode1.database.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

  //  Abaixo alguns exemplos de métodos de busca do JPA
  List<Account> findByBalanceLessThan(BigDecimal balance);

  List<Account> findByBalanceLessThanEqual(BigDecimal balance);

  List<Account> findByBalanceGreaterThan(BigDecimal balance);

  List<Account> findByBalanceGreaterThanEqual(BigDecimal balance);

  List<Account> findByBalanceBetween(BigDecimal openingBalance, BigDecimal finalBalance);

  List<Account> findByBalanceIn(List<BigDecimal> balances);

  List<Account> findByAccountTypeAndBalanceBetweenOrderByBalance(
      AccountType accountType, BigDecimal openingBalance, BigDecimal finalBalance);

  List<Account> findByUser_cpf(String cpf);

  Boolean existsByAccountType(AccountType accountType);

  //  Este é o modo de escrever uma query nativa do jpa
  //  Os dois pontos serverm para deixar o argumento parametrizável
  @Query(
      "select c from Account c "
          + "where (c.accountType = :tipoDeConta and c.user.cpf = :cpfNumero) "
          + "or (c.accountType = :tipoDeConta or c.balance = :saldo)")
  List<Account> findByAccountTypeAndCpfOrAccountTypeAndBalance(
      @Param("tipoDeConta") AccountType accountType,
      @Param("cpfNumero") String cpf,
      @Param("saldo") BigDecimal balance);

  //  Criando uma query para encontrar pelo tipo de conta e nome, usando dois tipos de query
  @Query(
      "select c from Account c "
          + "where c.accountType = :tipoDeConta and c.user.name = :nomeDoUsuario")
  List<Account> findByAccountTypeAndUserName(
      @Param("tipoDeConta") AccountType accountType, @Param("nomeDoUsuario") String name);

  @Query(
      value =
          "select * from conta c"
              + "inner join usuario u"
              + "on u.id = c.usuario.id"
              + "where c.tipo_conta = :tipoDeConta and u.nome = :nomeDoUsuario",
      nativeQuery = true)
  List<Account> findByAccountTypeAndUserNome(
      @Param("tipoDeConta") AccountType accountType, @Param("nomeDoUsuario") String name);

  //  Este é o modo de escrever uma query nativa
  @Query(
      value =
          "select * from conta c"
              + "where (c.tipo_conta = :tipoDeConta AND"
              + "c.data_criacao >= :dataDeCriacao)"
              + "OR c.saldo = :saldoDaConta ",
      nativeQuery = true)
  List<Account> findByCreationDateAndAccountTypeOrBalance(
      @Param("dataDeCriacao") LocalDateTime updateDate,
      @Param("tipoDeConta") LocalDateTime accountType,
      @Param("saldoDaConta") BigDecimal balance);
}
