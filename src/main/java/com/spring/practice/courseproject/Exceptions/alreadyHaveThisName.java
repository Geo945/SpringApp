package com.spring.practice.courseproject.Exceptions;

public class alreadyHaveThisName extends Exception{

    public alreadyHaveThisName(String student_name){
        super("You already have the name " + student_name + " as your username");
    }

}
