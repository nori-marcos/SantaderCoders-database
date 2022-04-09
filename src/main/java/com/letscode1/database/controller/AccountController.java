package com.letscode1.database.controller;

import com.letscode1.database.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;


//    @GetMapping
//    public List<User> getAll(@RequestParam(required = false) String name) {
//        return userService.getAll(name);
//    }
//
//    @PostMapping
//    public UserResponse create(@RequestBody UserRequest usuarioRequest) {
//        return userService.create(usuarioRequest);
//    }
//
//    @GetMapping("/{id}")
//    public User getById(@PathVariable Integer id){
//        return userService.getById(id);
//    }
//
//    @PutMapping("/{id}")
//    public User update(@PathVariable Integer id, @RequestBody UserRequest userRequest){
//        return userService.update(userRequest, id);
//    }



}
