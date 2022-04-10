package com.letscode1.database.service.impl;

import com.letscode1.database.DTO.response.UserResponse;
import com.letscode1.database.model.User;
import com.letscode1.database.repository.UserRepository;
import com.letscode1.database.DTO.request.UserRequest;
import com.letscode1.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired UserRepository userRepository;

  @Override
  public Page<User> getAll(String name, int page, int size) {
    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");

    if (name != null) {
      return userRepository.findByName(name, pageRequest);
    } else {
      return userRepository.findAll(pageRequest);
    }
  }

  @Override
  public Page<UserResponse> getAllByCpf(String cpf, int page, int size){
    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
    return userRepository.findByCpf(cpf, pageRequest);
  }

  @Override
  public UserResponse create(UserRequest userRequest) {
    User user = new User(userRequest);
    user = userRepository.save(user);

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
    User user = userRepository.findById(id).orElseThrow();

    user.setName(userRequest.getName());
    user.setCpf(userRequest.getCpf());
    user.setPassword(userRequest.getPassword());

    return userRepository.save(user);
  }

  @Override
  public void delete(Integer id) {
    User user = userRepository.findById(id).orElseThrow();
    userRepository.delete(user);
  }
}
