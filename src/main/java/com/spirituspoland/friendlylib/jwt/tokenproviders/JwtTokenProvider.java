package com.spirituspoland.friendlylib.jwt.tokenproviders;

import com.spirituspoland.friendlylib.jwt.JwtProperties;
import com.spirituspoland.friendlylib.service.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

@RequiredArgsConstructor
public abstract class JwtTokenProvider {
    final JwtProperties jwtProperties;
    final JwtParser tokenParser;

    public abstract String generateJwtToken(UserPrincipal userPrincipal);

    public boolean isTokenValid(String username, String token) {
        return StringUtils.isNotBlank(username) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        Date expiration = tokenParser.parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

    public String getSubject(String token) {
        return tokenParser.parseClaimsJws(token).getBody().getSubject();
    }

    public Claims verifyToken(String token) {
        return tokenParser.parseClaimsJws(token).getBody();
    }

    public List<GrantedAuthority> getAuthoritiesFromToken(String token) {
        return
            Arrays.stream(tokenParser.parseClaimsJws(token)
                    .getBody()
                    .getAudience()
                    .split(","))
                .map(SimpleGrantedAuthority::new).collect(
                    Collectors.toList());
    }


    public Authentication getAuthentication(String username, List<GrantedAuthority> authorities, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken userPasswordToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
        userPasswordToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return userPasswordToken;
    }

    protected String getAuthoritiesFromUser(UserPrincipal userPrincipal) {
        return userPrincipal.getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));
    }
}
