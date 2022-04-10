package com.letscode1.database.repository;

import com.letscode1.database.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
class UserRepositoryTest {

  @Autowired private TestEntityManager entityManager;

  @Autowired private UserRepository userRepository;

  @Test
  void findAll_is_empty_id_repository_is_empty() {
    List<User> users;
    users = userRepository.findAll();

    Assertions.assertEquals(Arrays.asList(), users);
  }

  @Test
  void findByCpf() {}
}
