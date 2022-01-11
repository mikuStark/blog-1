package com.example.blog.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Error. User Not Found");
    }
}