package com.spirituspoland.friendlylib.controller;

import com.spirituspoland.friendlylib.dto.RoleDto;
import com.spirituspoland.friendlylib.model.Book;
import com.spirituspoland.friendlylib.service.BookService;
import com.spirituspoland.friendlylib.service.RoleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDto>> findAllRoles(){
        return ResponseEntity.ok(roleService.findAllRoles());
    }
}
