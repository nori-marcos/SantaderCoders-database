package com.letscode1.database.repository;

import com.letscode1.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByName(String name);

  //  Alguns exemplos de métodos do JPA
  List<User> findByNameAndCpf(String name, String cpf);

  List<User> findByNameIs(String name);

  List<User> findByNameIsNot(String name);

  List<User> findByNameIsNull();

  List<User> findByNameIsNotNull();

  List<User> findByCpfStartingWith(String cpf);

  List<User> findByCpfEndingWith(String cpf);

  List<User> findByCpfContaining(String cpf);

  List<User> findByNameLike(String pattern);

  List<User> findByCreationDateBeforeAndNameAndCpf(
      LocalDateTime creationDate, String name, String cpf);

  List<User> findByCreationDate(LocalDateTime creationDate);

  List<User> findByNameAndCreationDateOrderByNameAsc(String name, LocalDateTime creationDate);

  User findByCpf(String cpf);
}
