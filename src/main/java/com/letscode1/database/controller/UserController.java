package com.letscode1.database.controller;

import com.letscode1.database.model.User;
import com.letscode1.database.DTO.request.UserRequest;
import com.letscode1.database.DTO.response.UserResponse;
import com.letscode1.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired UserService userService;

  @GetMapping
  public List<User> getAll(@RequestParam(required = false) String name) {
    return userService.getAll(name);
  }

  @PostMapping
  public UserResponse create(@RequestBody UserRequest usuarioRequest) {
    return userService.create(usuarioRequest);
  }

  @GetMapping("/{id}")
  public User getById(@PathVariable Integer id){
    return userService.getById(id);
  }

  @PutMapping("/{id}")
  public User update(@PathVariable Integer id, @RequestBody UserRequest userRequest){
    return userService.update(userRequest, id);
  }
}
