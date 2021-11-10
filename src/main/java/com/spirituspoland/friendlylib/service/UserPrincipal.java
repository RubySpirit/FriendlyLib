package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.model.Role;
import com.spirituspoland.friendlylib.model.User;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@Data
@Slf4j
public class UserPrincipal implements UserDetails {
    private User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
            .map(this::getAuthority)
            .collect(Collectors.toList());
        log.info("User roles:" + authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isActive();
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

    public User getUser() {
        return user;
    }

    private SimpleGrantedAuthority getAuthority(Role role) {
        return new SimpleGrantedAuthority(String.format("ROLE_%s", role.getName().name()));
    }
}
