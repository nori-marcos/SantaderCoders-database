package com.letscode1.database.service;

import com.letscode1.database.DTO.response.UserResponse;
import com.letscode1.database.model.User;
import com.letscode1.database.DTO.request.UserRequest;

import java.util.List;

public interface UserService {
  List<User> getAll(String name);

  List<User> search(String search);

  List<UserResponse> getAllByCpf(String cpf);

  UserResponse create(UserRequest userRequest);

  User getById(Integer id);

  User update(UserRequest userRequest, Integer id);

  void delete(Integer id);
}
