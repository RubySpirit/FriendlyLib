package com.spirituspoland.friendlylib.jwt.tokenproviders;

import com.spirituspoland.friendlylib.jwt.JwtProperties;
import com.spirituspoland.friendlylib.service.UserPrincipal;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class JwtRefreshTokenProvider extends JwtTokenProvider {
    public JwtRefreshTokenProvider(JwtProperties jwtProperties, JwtParser tokenParser) {
        super(jwtProperties, tokenParser);
    }

    public String generateJwtToken(UserPrincipal userPrincipal, boolean rememberMe) {
        long expiration = rememberMe ? jwtProperties.getRememberMeExpirationTime() : jwtProperties.getRefreshTokenExpirationTime();
        return Jwts.builder()
            .setIssuer(jwtProperties.getIssuer())
            .setIssuedAt(new Date())
            .setSubject(userPrincipal.getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(expiration)))
            .addClaims(Map.of("remember_me", rememberMe))
            .signWith(SignatureAlgorithm.HS512, jwtProperties.getRefreshTokenSecret().getBytes())
            .compact();

    }

    @Override
    public String generateJwtToken(UserPrincipal userPrincipal) {
        return generateJwtToken(userPrincipal, false);
    }

    @Override
    public boolean isTokenValid(String username, String token) {
        return StringUtils.isNotBlank(username) && !isTokenExpired(token);
    }


}
