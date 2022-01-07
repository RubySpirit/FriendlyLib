package com.spirituspoland.friendlylib.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.spirituspoland.friendlylib.dto.BasicFacilityDTO;
import lombok.Data;

@Entity(name = "facilities")
@Data
public class Facility {

    @Id
    private Long  id;
    private String name;
    private String workingHours;
    private String phone;
    private String email;
    private String city;
    private String zipCode;
    private String state;
    private String street;
    private LocalDateTime lastUpdated;

    @OneToMany
    @JoinColumn(name="id")
    private List<Book> books;

    @OneToMany(mappedBy = "originFacility")
    private List<User> users;

}
