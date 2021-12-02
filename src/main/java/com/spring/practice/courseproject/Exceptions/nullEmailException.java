package com.spring.practice.courseproject.Exceptions;

public class nullEmailException extends Exception{

    public nullEmailException(){
        super("Email cannot be empty!");
    }
}
