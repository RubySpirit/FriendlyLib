package com.spirituspoland.friendlylib.mapper;

import com.spirituspoland.friendlylib.dto.RoleDto;
import com.spirituspoland.friendlylib.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {

    @Mapping(expression = "java(role.getName().toString())",target = "name")
    public abstract RoleDto toRoleDto(Role role);
}
