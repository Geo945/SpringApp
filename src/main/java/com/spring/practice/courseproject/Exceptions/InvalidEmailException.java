package com.spring.practice.courseproject.Exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(){
        super("Invalid email!");
    }
}
