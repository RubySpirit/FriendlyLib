package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.jwt.tokenproviders.JwtAccessTokenProvider;
import com.spirituspoland.friendlylib.jwt.tokenproviders.JwtRefreshTokenProvider;
import com.spirituspoland.friendlylib.jwt.request.JwtRequest;
import com.spirituspoland.friendlylib.jwt.responses.LoginJwtResponse;
import com.spirituspoland.friendlylib.jwt.responses.RefreshJwtResponse;
import com.spirituspoland.friendlylib.model.User;
import com.spirituspoland.friendlylib.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtAccessTokenProvider jwtAccessTokenProvider;
    private final JwtRefreshTokenProvider jwtRefreshTokenProvider;

    public LoginJwtResponse login(JwtRequest jwtRequest) {
        authenticate(jwtRequest.email(), jwtRequest.password());
        UserPrincipal user = findUser(jwtRequest.email());
        String jwtToken = jwtAccessTokenProvider.generateJwtToken(user);
        String refreshToken = jwtRefreshTokenProvider.generateJwtToken(user, jwtRequest.rememberMe());
        return new LoginJwtResponse(jwtToken, refreshToken);
    }

    public RefreshJwtResponse refresh(String refreshToken) {
        Claims decodedJWT = jwtRefreshTokenProvider.verifyToken(refreshToken);
        UserPrincipal user = findUser(decodedJWT.getSubject());
        String jwtToken = jwtRefreshTokenProvider.generateJwtToken(user);
        boolean rememberMe = decodedJWT.get("remember_me",Boolean.class);
        String newRefreshToken = jwtRefreshTokenProvider.generateJwtToken(user, rememberMe);
        return new RefreshJwtResponse(jwtToken, newRefreshToken);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    private UserPrincipal findUser(String email) {
        User loggedUser = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email: %s not found", email)));
        return new UserPrincipal(loggedUser);
    }

}
