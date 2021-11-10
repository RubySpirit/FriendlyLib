package com.spirituspoland.friendlylib.dto;

public record ChangePasswordDto(String oldPassword,String newPassword,String repeatedNewPassword) {

    public boolean isNewPasswordMatches(){
        return repeatedNewPassword.equals(newPassword);
    }
}
