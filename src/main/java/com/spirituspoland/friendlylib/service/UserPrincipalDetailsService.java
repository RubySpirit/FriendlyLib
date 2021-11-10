package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.model.User;
import com.spirituspoland.friendlylib.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email: %s was not found", s)));
        user.setLastLogonAt(LocalDateTime.now());
        userRepository.save(user);
        log.info(String.format("Found user with email: %s",s));
        return new UserPrincipal(user);
    }
}
