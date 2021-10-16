package com.spirituspoland.friendlylib.model;

import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Title {
    @Id
    private UUID id;
    private String author;
    private String description;
    private File photo;
    private double rating;
    private int numberOfVotes;
    @ManyToMany
    private List<Category> categories;
}