package com.spirituspoland.friendlylib.dto;

import java.time.LocalDateTime;

public record CreateFacilityDTO(
        String name,
        String workingHours,
        String phone,
        String email,
        String city,
        String zipCode,
        String state,
        String street,
        LocalDateTime lastUpdated) {
}
