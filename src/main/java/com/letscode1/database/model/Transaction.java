package com.letscode1.database.model;

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

@Table(name = "transacao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "valor")
  private BigDecimal transactionValue;

  @Column(name = "tipo_transacao")
  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  @Column(name = "numero")
  private Integer number;

  @Column(name = "agencia")
  private Integer agency;

  @Column(name = "data_criacao")
  @CreatedDate
  private LocalDateTime creationDate;

  @Column(name = "data_atualizacao")
  @LastModifiedDate
  @UpdateTimestamp
  private LocalDateTime updateDate;

  @ManyToOne
  @JoinColumn(name = "conta_id", referencedColumnName = "id")
  private Account account;
}
