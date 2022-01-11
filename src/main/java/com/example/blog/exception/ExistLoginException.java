package com.example.blog.exception;

public class ExistLoginException extends RuntimeException{
    public ExistLoginException() {
        super("Error. Login is Exist");
    }
}