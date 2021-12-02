package com.spring.practice.courseproject.Configurations;

import com.spring.practice.courseproject.Model.Student;
import com.spring.practice.courseproject.Repositorys.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
//A Functional Interface is an Interface with just one Abstract Method. We can also use Method Reference to implement Functional Interfaces.

@Configuration
public class StudentConfig {
    //Spring @Bean Annotation is applied on a method to specify that it returns a bean to be managed by Spring context.
    // Spring Bean annotation is usually declared in Configuration classes methods.
    // In this case, bean methods may reference other @Bean methods in the same class by calling them directly.



    //This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
    //Interface used to indicate that a bean should run when it is contained within a SpringApplication. Multiple CommandLineRunner beans can be defined within the same application context and can be ordered using the Ordered interface or @Order annotation.
    //If you need access to ApplicationArguments instead of the raw String array consider using ApplicationRunner.
    @Bean//cand dau run la proiect se apeleaza functia, se baga in spring container ca si bean
    @Order(1)//daca aveam mai multe @Bean ce returnau CommandLineRunner cand dau run la aplicatie, atunci asta se executa primul pt ca am @Order(1) si asa poti sa
    //specifici in ce ordine ruleaza.
    public CommandLineRunner commandLineRunner(StudentRepository repo){
        return args -> {
            Student andrei = new Student("Andrei", LocalDate.of(2000, Month.NOVEMBER, 5),"andrei@gmail.com");
            Student alex = new Student("Alex", LocalDate.of(2005, Month.JANUARY, 15),"alex@gmail.com");
            repo.saveAll(List.of(andrei,alex));
        };
    }

}
