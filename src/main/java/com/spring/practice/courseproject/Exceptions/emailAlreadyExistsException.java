package com.spring.practice.courseproject.Exceptions;

public class emailAlreadyExistsException extends Exception{
    public emailAlreadyExistsException() {
        super("This email is already taken!");
    }
}
