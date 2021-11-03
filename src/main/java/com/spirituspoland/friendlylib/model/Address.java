package com.spirituspoland.friendlylib.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
public class Address {
    @Id
    private Long  id;


    @OneToOne
    @JoinColumn(name = "id")
    private Facility facilities;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

}
