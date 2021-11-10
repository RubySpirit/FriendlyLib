package com.spirituspoland.friendlylib.repository.exceptions;

public class RoleNotFoundException extends Exception {
    public RoleNotFoundException(String roleName) {
        super(String.format("Role with name: %s not exist", roleName));
    }
}
