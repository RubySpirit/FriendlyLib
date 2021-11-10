package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.dto.RoleDto;
import com.spirituspoland.friendlylib.mapper.RoleMapper;
import com.spirituspoland.friendlylib.repository.RoleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public List<RoleDto> findAllRoles(){
        return roleRepository.findAll().stream().map(roleMapper::toRoleDto).collect(Collectors.toList());
    }
}
