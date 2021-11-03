package com.spirituspoland.friendlylib.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "title_reviews")
@Data
public class TitleReview {

    @Id
    private Long  id;
    private String description;
    private BigDecimal rating;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="title_id")
    private Title title;
    private LocalDateTime createdAt;
}
