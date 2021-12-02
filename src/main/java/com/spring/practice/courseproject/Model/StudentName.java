package com.spring.practice.courseproject.Model;

import javax.persistence.Embeddable;

@Embeddable//because we have private StudentName fullname; field in Student model and we save the student class
//to the postgresql we need to put this embeddable, so this class will get embeded inside of Student table.
//this is hibernate
public class StudentName {
    private String firstName;
    private String middleName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
