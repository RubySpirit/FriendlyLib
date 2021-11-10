package com.spirituspoland.friendlylib.mapper;

import com.spirituspoland.friendlylib.dto.BasicUserInfoDTO;
import com.spirituspoland.friendlylib.dto.CreateUserDTO;
import com.spirituspoland.friendlylib.model.Role;
import com.spirituspoland.friendlylib.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    List<Role> roleToList(Role role) {
        return List.of(role);
    }

    public abstract User createUserToEntity(CreateUserDTO userDTO, Role role);
    public abstract CreateUserDTO toCreatedUserDTO(User user);

    public abstract BasicUserInfoDTO toBasicInfo(User user);

    public abstract List<BasicUserInfoDTO> toBasicInfo(List<User> users);

    public abstract List<String> roleToString(List<Role> roles);

    public String roleToString(Role role){
        return role.getName().toString();
    }

}
