package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.model.Role;
import com.spirituspoland.friendlylib.model.User;
import com.spirituspoland.friendlylib.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Page<User> findAllReaders(Pageable pageable) {
        return userRepository.findAllByRole(Role.READER, pageable);
    }

    public Page<User> findAllLibrarians(Pageable pageable){
        return userRepository.findAllByRole(Role.LIBRARIAN,pageable);
    }

    public Page<User> findAllUsers(Pageable pageable){
        return userRepository.findAllByRoleIsOrRoleIs(Role.READER,Role.LIBRARIAN, pageable);
    }
}
