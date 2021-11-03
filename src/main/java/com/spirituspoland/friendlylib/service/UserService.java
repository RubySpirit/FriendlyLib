package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.model.RoleName;
import com.spirituspoland.friendlylib.model.User;
import com.spirituspoland.friendlylib.repository.RoleRepository;
import com.spirituspoland.friendlylib.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Page<User> findAllReaders(Pageable pageable) {
        return userRepository.findAllByRoles_Name(RoleName.READER, pageable);
    }

    public Page<User> findAllLibrarians(Pageable pageable){
        return userRepository.findAllByRoles_Name(RoleName.LIBRARIAN,pageable);
    }

    public Page<User> findAllUsers(Pageable pageable){
        return userRepository.findAllByRoles_NameIsOrRoles_NameIs(RoleName.READER,RoleName.LIBRARIAN, pageable);
    }

    public User addReader(User user){
        return userRepository.save(user);
    }
    public User addLibrarian(User user){
        return userRepository.save(user);
    }

    public User updateReader(User user){
        return userRepository.save(user);
    }
    public User updateLibrarian(User user){
        return userRepository.save(user);
    }

    public User getUser(UserPrincipal userPrincipal){
        return userPrincipal.getUser();
    }


}
