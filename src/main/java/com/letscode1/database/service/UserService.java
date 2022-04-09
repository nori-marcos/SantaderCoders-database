package com.letscode1.database.service;

import com.letscode1.database.model.User;
import com.letscode1.database.request.UserRequest;
import com.letscode1.database.response.UserResponse;
import org.springframework.data.domain.Page;

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
