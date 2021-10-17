package com.spirituspoland.friendlylib.controller;

import com.spirituspoland.friendlylib.model.User;
import com.spirituspoland.friendlylib.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/readers")
    public Page<User> findAllReaders(Pageable pageable){
        return userService.findAllReaders(pageable);
    }
    @GetMapping("/librarians")
    public Page<User> findAllLibrarians(Pageable pageable){
        return userService.findAllLibrarians(pageable);
    }
}
