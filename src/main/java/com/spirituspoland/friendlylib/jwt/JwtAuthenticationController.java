package com.spirituspoland.friendlylib.jwt;

import com.spirituspoland.friendlylib.jwt.request.JwtRefreshRequest;
import com.spirituspoland.friendlylib.jwt.request.JwtRequest;
import com.spirituspoland.friendlylib.jwt.responses.LoginJwtResponse;
import com.spirituspoland.friendlylib.jwt.responses.RefreshJwtResponse;
import com.spirituspoland.friendlylib.service.JwtService;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/", "/user"})
@RequiredArgsConstructor
public class JwtAuthenticationController {
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginJwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        LoginJwtResponse jwtResponse = jwtService.login(jwtRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<RefreshJwtResponse> refreshToken(@RequestBody JwtRefreshRequest jwtRefreshRequest) {
        RefreshJwtResponse refreshJwtResponse;
        try {
             refreshJwtResponse = jwtService.refresh(jwtRefreshRequest.refreshToken());
        } catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (JwtException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(refreshJwtResponse);
    }

}
