package com.spirituspoland.friendlylib.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {
    @Id
    private Long  id;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
        name = "role_assignment",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;

    private String email;
    private String phone;
    private LocalDateTime created;
    private LocalDateTime lastLogon;
    private String password;
    private boolean active;
    private String city;
    private String zipCode;
    private String state;
    private String street;
    private LocalDateTime lastUpdated;
}
