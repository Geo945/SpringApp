package com.spring.practice.courseproject.Exceptions;

public class alreadyHaveThisEmail extends Exception{

    public alreadyHaveThisEmail(String student_email){
        super("You already have the mail " + student_email + " as your email");
    }

}
