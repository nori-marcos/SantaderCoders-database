package com.letscode1.database.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
  private String cpf;
  private String name;
  private String password;
}
