package com.spirituspoland.friendlylib.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_assignment",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    @ToString.Exclude
    @JsonIgnore
    private List<Role> roles;

    private String email;
    @ManyToOne
    @JoinColumn(name = "origin_facility_id")
    private Facility originFacility;

    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogonAt;
    private String password;
    private boolean active;
    private String city;
    private String zipCode;
    private String state;
    private String street;
    private LocalDateTime lastUpdated;
}
