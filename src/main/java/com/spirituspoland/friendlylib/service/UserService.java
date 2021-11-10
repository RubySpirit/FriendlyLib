package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.dto.BasicUserInfoDTO;
import com.spirituspoland.friendlylib.dto.ChangePasswordDto;
import com.spirituspoland.friendlylib.dto.CreateUserDTO;
import com.spirituspoland.friendlylib.dto.CreatedUserDTO;
import com.spirituspoland.friendlylib.mapper.UserMapper;
import com.spirituspoland.friendlylib.model.Role;
import com.spirituspoland.friendlylib.model.RoleName;
import com.spirituspoland.friendlylib.model.User;
import com.spirituspoland.friendlylib.repository.RoleRepository;
import com.spirituspoland.friendlylib.repository.UserRepository;
import com.spirituspoland.friendlylib.service.exception.IncorrectPasswordException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public Page<User> findAllReaders(Pageable pageable) {
        return userRepository.findAllByRoles_Name(RoleName.READER, pageable);
    }

    public Page<User> findAllLibrarians(Pageable pageable) {
        return userRepository.findAllByRoles_Name(RoleName.LIBRARIAN, pageable);
    }

    public Page<BasicUserInfoDTO> findAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAllByRoles_NameIsOrRoles_NameIs(RoleName.READER, RoleName.LIBRARIAN, pageable);
        return users.map(userMapper::toBasicInfo);
    }

    public CreatedUserDTO addUser(CreateUserDTO userDTO) {
        Role role =
            roleRepository.findByName(userDTO.roleName()).orElseThrow(() -> new UsernameNotFoundException(userDTO.roleName().toString()));
        User user = userMapper.createUserToEntity(userDTO, role);
        String password = generateRandomPassword();
        user.setPassword(passwordEncoder.encode(password));
        user = userRepository.save(user);
        return new CreatedUserDTO(user.getEmail(), password);
    }

    public User addReader(User user) {
        return userRepository.save(user);
    }

    public User addLibrarian(User user) {
        return userRepository.save(user);
    }

    public User updateReader(User user) {
        return userRepository.save(user);
    }

    public User updateLibrarian(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email: %s not found", email)));
    }

    public void changeUserPassword(String email, ChangePasswordDto changePasswordDto) {
        if (changePasswordDto.isNewPasswordMatches()) {
            User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email: %s not found", email)));
            if (passwordEncoder.matches(changePasswordDto.oldPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(changePasswordDto.newPassword()));
                userRepository.save(user);
                return;
            }
            throw new IncorrectPasswordException();
        }
    }


    private String generateRandomPassword() {
        return RandomStringUtils.random(10, true, true);
    }

}
