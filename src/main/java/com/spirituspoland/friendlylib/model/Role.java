package com.spirituspoland.friendlylib.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity(name = "roles")
@Data
public class Role {
    @Id
    private Long  id;

    @Enumerated(EnumType.STRING)
    private RoleName name;
    private String description;

    @ManyToMany
    private List<User> users;


}
