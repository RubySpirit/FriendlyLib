package com.spirituspoland.friendlylib.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    private UUID id;
    private String name;
    private String description;

    @ManyToMany
    List<Title> titles;
}
