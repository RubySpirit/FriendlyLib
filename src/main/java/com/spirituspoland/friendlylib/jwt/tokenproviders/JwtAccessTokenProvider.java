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


@Slf4j
public class JwtAccessTokenProvider extends JwtTokenProvider {

    public JwtAccessTokenProvider(JwtProperties jwtProperties, JwtParser tokenParser) {
        super(jwtProperties, tokenParser);
    }

    public String generateJwtToken(UserPrincipal userPrincipal) {
        return
            Jwts.builder()
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(new Date())
                .setSubject(userPrincipal.getUsername())
                .setAudience(getAuthoritiesFromUser(userPrincipal))
                .addClaims(Map.of("firstName", userPrincipal.getUser().getFirstName(),
                    "lastName", userPrincipal.getUser().getLastName()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(jwtProperties.getTokenExpirationTime())))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getAccessTokenSecret().getBytes())
                .compact();
    }


}
