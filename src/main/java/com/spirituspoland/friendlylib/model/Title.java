package com.spirituspoland.friendlylib.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity(name = "titles")
@Data
public class Title {
    @Id
    private UUID id;
    private String author;
    private String description;
    //private File photo;
    private double rating;
    private int numberOfVotes;
    @ManyToMany
    private List<Category> categories;

    @OneToMany
    private List<Book> books;
}
