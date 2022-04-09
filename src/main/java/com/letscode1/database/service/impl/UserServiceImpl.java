package com.letscode1.database.service.impl;

import com.letscode1.database.model.User;
import com.letscode1.database.repository.UserRepository;
import com.letscode1.database.request.UserRequest;
import com.letscode1.database.response.UserResponse;
import com.letscode1.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired UserRepository userRepository;

  @Override
  public List<User> getAll(String name) {
    if (name != null) {
      return userRepository.findByName(name);
    } else {
      return userRepository.findAll();
    }
  }

  @Override
  public UserResponse create(UserRequest userRequest) {
    User user = new User(userRequest);
    userRepository.save(user);

    return new UserResponse(user);
  }

  @Override
  public User getById(Integer id) {
    return userRepository.findById(id).orElseThrow();
  }


  @Override
  public List<User> search(String search) {
    return null;
  }

  @Override
  public List<UserResponse> getAllByCpf(String cpf) {
    return null;
  }


  @Override
  public User update(UserRequest userRequest, Integer id) {
    return null;
  }

  @Override
  public void delete(Integer id) {}
}
