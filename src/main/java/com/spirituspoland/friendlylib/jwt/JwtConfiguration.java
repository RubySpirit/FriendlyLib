package com.spirituspoland.friendlylib.jwt;

import com.spirituspoland.friendlylib.jwt.tokenproviders.JwtAccessTokenProvider;
import com.spirituspoland.friendlylib.jwt.tokenproviders.JwtRefreshTokenProvider;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class JwtConfiguration {
    private final JwtProperties jwtProperties;

    @Bean
    JwtParser jwtAccessTokenParser() {
        return Jwts.parser()
            .setSigningKey(jwtProperties.getAccessTokenSecret().getBytes())
            .requireIssuer(jwtProperties.getIssuer());

    }

    @Bean
    JwtParser jwtRefreshTokenParser() {
        return Jwts.parser()
            .setSigningKey(jwtProperties.getRefreshTokenSecret().getBytes())
            .requireIssuer(jwtProperties.getIssuer())
            .require("remember_me",Boolean.class);
    }

    @Bean
    JwtAccessTokenProvider jwtAccessTokenProvider() {
        return new JwtAccessTokenProvider(jwtProperties, jwtAccessTokenParser());
    }
    @Bean
    JwtRefreshTokenProvider jwtRefreshTokenProvider(){
        return new JwtRefreshTokenProvider(jwtProperties, jwtRefreshTokenParser());
    }


}
