package com.example.blog.exception;

public class NotFoundId extends RuntimeException{
    public NotFoundId() {
        super("Error. Id Not Found");
    }
}
