package com.letscode1.database.repository;

import com.letscode1.database.DTO.response.UserResponse;
import com.letscode1.database.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Page<User> findByName(String name, Pageable pageable);

  @Query(
      "select new com.letscode1.database.DTO.response.UserResponse(u.id, u.cpf, u.name, u.creationDate, u.updateDate) "
          + "from User u where u.cpf = :cpf")
  Page<UserResponse> findByCpf(@Param("cpf") String cpf, Pageable pageable);
}
