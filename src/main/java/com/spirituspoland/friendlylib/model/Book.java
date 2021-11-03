package com.spirituspoland.friendlylib.model;


import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "books")
@Data
public class Book {
    @Id
    private Long  id;

    @ManyToOne
    private Title title;
    private LocalDateTime addedAt;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne
    private Facility facility;

}
