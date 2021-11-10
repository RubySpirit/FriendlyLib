package com.spirituspoland.friendlylib.service.exception;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("Provided old password incorrect");
    }
}
