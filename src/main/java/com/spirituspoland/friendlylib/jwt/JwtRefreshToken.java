package com.spirituspoland.friendlylib.jwt;

import java.time.LocalDateTime;

public record JwtRefreshToken(
    String token,
    LocalDateTime expirationDate) {
}
