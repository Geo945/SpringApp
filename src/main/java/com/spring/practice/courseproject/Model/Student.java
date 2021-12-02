package com.spring.practice.courseproject.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity//hibernate//to map student to our database this anotation is for hibernate, short to create a table of this class
@Table//hibernate//this one is for the table in our database, Can use @Table(name="student_table") so the table name will be student_table
public class Student {

    @Id//hibernate
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @Embedded//used to store unpredefined objects variables to database,this is hibernate
    private StudentName fullname;
    private String name;
    @Transient//it just says that the field age is no need to be a column in our database, so the field age will not appear in the database table
    //this is hibernate
    private Integer age;
    //if I want the Localdate column on the table to be something else but not "dob" - the name of the variabile
    //I can use @Column(name="student_dob") for example and the name of the column will be student_dob
    private LocalDate dob;
    private String email;

    public StudentName getFullname() {
        return fullname;
    }

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    //because the db will generate the id for us
    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //de intrebat, Daca modific orice getter, cand dau findAll sa imi afiseze toti studentii din database o sa ia valoarea returnata de gettere
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
