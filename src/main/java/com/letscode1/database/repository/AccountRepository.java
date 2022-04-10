package com.letscode1.database.repository;

import com.letscode1.database.model.Account;
import com.letscode1.database.model.AccountType;
import com.letscode1.database.projection.AccountView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

  @Query("select a from Account a where (a.user.cpf = :cpfDoUsuario)")
  Account findByCpf(@Param("cpfDoUsuario") String cpf);

  Page<Account> findByUser_Name(String name, Pageable pageable);

  @Query("select a from Account a " + "where (a.user.name = :nomeDoUsuario) ")
  Account findByName(@Param("nomeDoUsuario") String name);

  Account findByUser_CpfAndNumberAndAgency(String cpf, Integer number, Integer agency);

  List<AccountView> findAllByAccountType(AccountType accountType);
}
