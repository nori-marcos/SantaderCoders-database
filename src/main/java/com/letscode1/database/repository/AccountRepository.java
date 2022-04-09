package com.letscode1.database.repository;

import com.letscode1.database.model.Account;
import com.letscode1.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

  @Query("select a from Account a " + "where (a.user.cpf = :cpfDoUsuario) ")
  Account findByCpf(@Param("cpfDoUsuario") String cpf);

  @Query
  List<Account> findByUser(User user);

}
