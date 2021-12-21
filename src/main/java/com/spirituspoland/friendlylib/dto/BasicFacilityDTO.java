package com.spirituspoland.friendlylib.dto;

public record BasicFacilityDTO(Long id,
                               String name,
                               String workingHours,
                               String phone,
                               String email,
                               String city,
                               String zipCode,
                               String state,
                               String street) {
}
