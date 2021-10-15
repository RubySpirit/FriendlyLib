package com.spirituspoland.friendlylib.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
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

    @OneToOne
    @JoinColumn(name = "id")
    private Facility facilities;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

}
