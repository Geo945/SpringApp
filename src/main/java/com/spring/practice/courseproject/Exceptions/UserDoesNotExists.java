package com.spring.practice.courseproject.Exceptions;

public class UserDoesNotExists extends Exception{

    public UserDoesNotExists(Long id){
        super(String.format("User with id %d does not exists!",id));
    }

}
