package com.spirituspoland.friendlylib.dto;


import java.time.LocalDateTime;
import java.util.UUID;

public record FacilityDTO(UUID id, String name, String workingHours, String city, String zipCode,
                          String state, String street, String phone, String emailAddress,
                          LocalDateTime lastUpdated) {

}
