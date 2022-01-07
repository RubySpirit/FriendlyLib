package com.spirituspoland.friendlylib.dto;

import com.spirituspoland.friendlylib.model.RoleName;

public record CreateUserDTO(String firstName,
                            String lastName,
                            RoleName roleName,
                            String email,
                            String phone,
                            String city,
                            String state,
                            String zipCode,
                            String street) {
}
