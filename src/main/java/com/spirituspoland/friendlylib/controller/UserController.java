package com.spirituspoland.friendlylib.controller;

import com.spirituspoland.friendlylib.dto.BasicUserInfoDTO;
import com.spirituspoland.friendlylib.dto.ChangePasswordDto;
import com.spirituspoland.friendlylib.dto.CreateUserDTO;
import com.spirituspoland.friendlylib.dto.CreatedUserDTO;
import com.spirituspoland.friendlylib.model.User;
import com.spirituspoland.friendlylib.service.UserService;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public Page<BasicUserInfoDTO> findAllUsers(Pageable pageable) {
        return userService.findAllUsers(pageable);
    }

    @GetMapping("/readers")
    public Page<User> findAllReaders(Pageable pageable) {
        return userService.findAllReaders(pageable);
    }

    @GetMapping("/librarians")
    public Page<User> findAllLibrarians(Pageable pageable) {
        return userService.findAllLibrarians(pageable);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/add")
    public CreatedUserDTO addNewUser(@RequestBody CreateUserDTO createUserDTO) {
        return userService.addUser(createUserDTO);
    }


    @Secured({"ROLE_ADMIN", "ROLE_LIBRARIAN"})
    @PostMapping("/add/reader")
    public User addReader(User user) {
        return userService.addReader(user);
    }
    public User addLibrarian(User user) {
        return userService.addLibrarian(user);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto, Principal principal) {
        userService.changeUserPassword(principal.getName(), changePasswordDto);
        return ResponseEntity.ok().build();
    }
}
