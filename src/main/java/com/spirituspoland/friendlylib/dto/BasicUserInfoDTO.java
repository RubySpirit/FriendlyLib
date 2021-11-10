package com.spirituspoland.friendlylib.dto;

import com.spirituspoland.friendlylib.model.RoleName;
import java.time.LocalDateTime;
import java.util.List;

public record BasicUserInfoDTO(String firstname,
                               String lastname,
                               String email,
                               boolean active,
                               LocalDateTime createdAt,
                               LocalDateTime lastLogonAt,
                               List<RoleName> roleNames) {
}
