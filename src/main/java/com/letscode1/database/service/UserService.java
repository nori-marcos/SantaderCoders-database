package com.letscode1.database.service;

import com.letscode1.database.DTO.request.UserRequest;
import com.letscode1.database.DTO.response.UserResponse;
import com.letscode1.database.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
  Page<User> getAll(String name, int page, int size);

  List<User> search(String search);

  List<UserResponse> getAllByCpf(String cpf);

    Page<UserResponse> getAllByCpf(String cpf, int page, int size);

    UserResponse create(UserRequest userRequest);

  User getById(Integer id);

  User update(UserRequest userRequest, Integer id);

  void delete(Integer id);
}
