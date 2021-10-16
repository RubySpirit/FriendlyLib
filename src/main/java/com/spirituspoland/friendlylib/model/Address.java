package com.spirituspoland.friendlylib.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity(name = "addresses")
@Data
public class Address {
    @Id
    private UUID id;
    private String city;
    private String zipCode;
    private String state;
    private String street;
    private String phone;
    private String emailAddress;
    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name = "id")
    private Facility facilities;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

}
