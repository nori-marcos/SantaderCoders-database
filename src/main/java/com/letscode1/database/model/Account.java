package com.letscode1.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "conta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "numero")
  private Integer number;

  @Column(name = "tipo_conta")
  @Enumerated(EnumType.STRING)
  private AccountType accountType;

  @Column(name = "saldo")
  private BigDecimal balance;

  @Column(name = "data_criacao")
  @CreatedDate
  private LocalDateTime creationDate;

  @Column(name = "data_atualizacao")
  @LastModifiedDate
  @UpdateTimestamp
  private LocalDateTime updateDate;

  @Column(name = "agencia")
  private Integer agency;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "usuario_id", referencedColumnName = "id")
  private User user;

  @JsonIgnore
  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
  private List<Transaction> transactionList;

}
