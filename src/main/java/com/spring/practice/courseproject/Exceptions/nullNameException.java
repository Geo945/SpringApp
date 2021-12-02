package com.spring.practice.courseproject.Exceptions;

public class nullNameException extends Exception{
    public nullNameException(){
        super("Student name cannot be empty!");
    }
}
