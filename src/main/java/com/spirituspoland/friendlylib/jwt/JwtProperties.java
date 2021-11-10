package com.spirituspoland.friendlylib.jwt;


import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "friendlylib.jwt")
public class JwtProperties {
    public static final String JWT_NOT_VERIFIED = "JWT not verified";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token ";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You don't have permission to access this page ";

    private String accessTokenSecret;
    private String refreshTokenSecret;
    private String issuer;
    private Long tokenExpirationTime;
    private Long refreshTokenExpirationTime;
    private Long rememberMeExpirationTime;

    public LocalDateTime generateRefreshTokenExpiration() {
        return LocalDateTime.now().plusMinutes(refreshTokenExpirationTime);
    }
    public LocalDateTime generateRememberMeTokenExpiration() {
        return LocalDateTime.now().plusMinutes(rememberMeExpirationTime);
    }



}
