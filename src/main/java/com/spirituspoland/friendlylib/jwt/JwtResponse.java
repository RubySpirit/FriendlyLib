package com.spirituspoland.friendlylib.jwt;

import java.util.List;
import java.util.UUID;
import lombok.Value;

@Value
public class JwtResponse {
    String jwtToken;
    UUID refreshToken;
    UUID rememberMe;
    String username;
    String email;
    List<String> roles;
}
