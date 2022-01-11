package com.example.blog.exception;

public class NotFoundIdException extends RuntimeException{
    public NotFoundIdException() {
        super("Error. Id Not Found");
    }
}
