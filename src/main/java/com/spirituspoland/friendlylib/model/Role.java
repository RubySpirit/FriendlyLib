package com.spirituspoland.friendlylib.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name ="roles")
@Data
public class Role {
    @Id
    private UUID id;

    private String name;
    private String description;
    @OneToMany(mappedBy = "id")
    private List<User> users;
}
