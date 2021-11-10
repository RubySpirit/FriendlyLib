package com.spirituspoland.friendlylib.jwt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record JwtRequest(String email,String password,boolean rememberMe) {
}
