package com.letscode1.database.repository;

import com.letscode1.database.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Page<User> findByName(String name, PageRequest pageable);

  User findByCpf(String cpf);
}
