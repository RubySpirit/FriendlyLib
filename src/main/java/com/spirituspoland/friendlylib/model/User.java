package com.spirituspoland.friendlylib.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    private String email;
    private String phone;
    private LocalDateTime created;
    private LocalDateTime lastLogon;
    @OneToOne
    @JoinColumn(name = "id")
    private Address address;
}
