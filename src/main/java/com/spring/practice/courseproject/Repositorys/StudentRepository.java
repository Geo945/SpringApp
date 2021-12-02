package com.spring.practice.courseproject.Repositorys;

import com.spring.practice.courseproject.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //to specify this is repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //JpaRepository<Student, Long> because id is Long in Student class

    Optional<Student> getStudentByEmail(String email);

    //mai sus folosesc findBy si dupa pot sa ii dau orice variabila din clasa
    //student si stie automat ce sa caute
    //metoda 2: face acelasi lucru ca metoda de la linia 13
    @Query("SELECT s FROM Student s WHERE s.email=?1")//Student din string e clasa Student
    Optional<Student> findStudentByyEmail(String email);

}
