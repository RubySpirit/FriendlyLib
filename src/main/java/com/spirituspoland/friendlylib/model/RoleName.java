package com.spirituspoland.friendlylib.model;

public enum RoleName {
    ADMIN("ADMIN"), LIBRARIAN("LIBRARIAN"), READER("READER");
    private final String name;

    private RoleName(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
