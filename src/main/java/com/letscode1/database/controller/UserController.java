package com.letscode1.database.controller;

import com.letscode1.database.model.User;
import com.letscode1.database.DTO.request.UserRequest;
import com.letscode1.database.DTO.response.UserResponse;
import com.letscode1.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired UserService userService;

  @GetMapping
  public Page<User> getAllPaged(@RequestParam(required = false) String name,
                           @RequestParam(required = false, defaultValue = "8") int page,
                           @RequestParam(required = false, defaultValue = "3")int size
  ){
    return userService.getAll(name, page, size);
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

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    userService.delete(id);
  }
}
