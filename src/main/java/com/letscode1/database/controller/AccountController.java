package com.letscode1.database.controller;

import com.letscode1.database.DTO.request.AccountRequest;
import com.letscode1.database.model.Account;
import com.letscode1.database.model.AccountType;
import com.letscode1.database.projection.AccountView;
import com.letscode1.database.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

  //  método para atualizar dados da conta pelo cpf
  @PutMapping("/cpf")
  public Account update(
      @RequestBody AccountRequest accountRequest, @RequestParam(required = true) String cpf) {
    return accountService.update(accountRequest, cpf);
  }

  //  método para pegar a lista de contas pelo CPF
  @GetMapping
  public Page<Account> getAll(
      @RequestParam(required = false) String name,
      @RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "5") int size) {
    return accountService.getAll(name, page, size);
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

  //  retorna uma view de contas
  @GetMapping("/view")
  public List<AccountView> getAllAccountViewByAccountType(@RequestParam AccountType accountType) {
    return accountService.getAllViewByAccountType(accountType);
  }
}
