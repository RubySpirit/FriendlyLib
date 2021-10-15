package com.spirituspoland.friendlylib.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Facility {

    @Id
    private UUID id;
    private String phone;
    private String name;
    private String number;
    private String city;
    private String street;
    private String zipCode;
    private String state;

    @OneToMany
    @JoinColumn(name="id")
    private List<Book> books;

    @OneToOne
    private Address address;
}
