package com.example.blog.exception;

public class EmptyPasswordException extends RuntimeException{
    public EmptyPasswordException() {
        super("Error. Password is Empty");
    }
}