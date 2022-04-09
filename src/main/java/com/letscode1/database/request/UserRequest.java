package com.letscode1.database.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UserRequest {
    private String cpf;
    private String name;
    private String password;
}
