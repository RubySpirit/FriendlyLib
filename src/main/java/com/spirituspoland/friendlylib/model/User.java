package com.spirituspoland.friendlylib.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {
  @Id
  private UUID id;
  private String name;
  private String surname;
  private Role role;
  private String email;
  private String phone;
  private LocalDateTime created;
  private LocalDateTime lastLogon;
  @OneToOne
  @JoinColumn(name = "id")
  private Address address;
}
