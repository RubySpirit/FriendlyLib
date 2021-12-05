package com.spirituspoland.friendlylib.configuration;

import static org.springframework.http.HttpStatus.OK;

import com.spirituspoland.friendlylib.jwt.JwtProperties;
import com.spirituspoland.friendlylib.jwt.tokenproviders.JwtAccessTokenProvider;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtAccessTokenProvider jwtAccessTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString())) {
            response.setStatus(OK.value());
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (Objects.isNull(authorizationHeader) || !authorizationHeader.startsWith(JwtProperties.TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            try {
                String token = authorizationHeader.substring(JwtProperties.TOKEN_PREFIX.length());
                String email = jwtAccessTokenProvider.getSubject(token);
                SecurityContext securityContext = SecurityContextHolder.getContext();

                if (jwtAccessTokenProvider.isTokenValid(email, token) && securityContext.getAuthentication() == null) {
                    List<GrantedAuthority> authorities = jwtAccessTokenProvider.getAuthoritiesFromToken(token);
                    Authentication authentication = jwtAccessTokenProvider.getAuthentication(email, authorities, request);
                    securityContext.setAuthentication(authentication);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } catch ( ExpiredJwtException ex) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"JWT token expired");
            return;
            }
            catch (JwtException ex){
                response.sendError(HttpServletResponse.SC_FORBIDDEN,ex.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }
}
