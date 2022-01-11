package com.example.blog.exception;

public class EmptyLoginException extends RuntimeException{
    public EmptyLoginException() {
        super("Error. Login is Empty");
    }
}