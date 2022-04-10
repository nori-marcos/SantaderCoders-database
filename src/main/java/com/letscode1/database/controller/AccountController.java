package com.letscode1.database.controller;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;
import com.letscode1.database.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired AccountService accountService;

  //  método para criar conta
  @PostMapping
  public Account create(
      @RequestBody AccountRequest accountRequest, @RequestParam(required = true) Integer userId) {
    return accountService.create(accountRequest, userId);
  }

  //  método para atualizar dados da conta
  @PutMapping
  public Account update(
      @RequestBody AccountRequest accountRequest, @RequestParam(required = true) String cpf) {
    return accountService.update(accountRequest, cpf);
  }

  //  método para pegar a lista de contas pelo CPF
  @GetMapping
  public List<Account> getAll(@RequestParam(required = false) String cpf) {
    return accountService.getAll(cpf);
  }

  //  método para buscar contas pelo id de conta
  @GetMapping("/{id}")
  public Account getById(@PathVariable Integer id) {
    return accountService.getById(id);
  }

  //  método para deletar contas pelo id de conta
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    accountService.delete(id);
  }
}
