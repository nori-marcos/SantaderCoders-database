package com.letscode1.database.DTO.response;

import com.letscode1.database.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
  private Integer id;
  private String cpf;
  private String name;
  private LocalDateTime creationDate;
  private LocalDateTime updateDate;

  public UserResponse(User user) {
    this.id = user.getId();
    this.cpf = user.getCpf();
    this.creationDate = user.getCreationDate();
    this.name = user.getName();
    this.updateDate = user.getUpdateDate();
  }

  public static List<UserResponse> toResponse(List<User> userList) {
    return userList.stream().map(UserResponse::new).collect(Collectors.toList());
  }
}
