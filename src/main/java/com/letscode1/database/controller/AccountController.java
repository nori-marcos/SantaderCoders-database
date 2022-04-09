package com.letscode1.database.controller;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;
import com.letscode1.database.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public Account create(@RequestBody AccountRequest accountRequest, @RequestParam(required = false) Integer userId) {
        return accountService.create(accountRequest, userId);
    }

}
