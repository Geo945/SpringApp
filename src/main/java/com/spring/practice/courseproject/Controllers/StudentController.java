package com.spring.practice.courseproject.Controllers;

import com.spring.practice.courseproject.Exceptions.*;
import com.spring.practice.courseproject.Model.Student;
import com.spring.practice.courseproject.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController()//makes class to serve rest end points(like method getStudents)
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path="/get")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/post")//used when you want to add new resources to you system
    public void registerNewStudent(@RequestBody Student student) throws emailAlreadyExistsException, InvalidEmailException {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/delete{student_id}")
    public void deleteStudent(@PathVariable Long student_id) throws UserDoesNotExists {
        studentService.deleteStudent(student_id);
    }

    //want to be able to update name or email with PUT method
    @PutMapping("/put{student_id}")
    public void updateStudent(@PathVariable Long student_id,@RequestParam(required = false) String student_name,@RequestParam(required = false) String student_email) throws UserDoesNotExists, InvalidEmailException, emailAlreadyExistsException {
        studentService.updateStudent(student_id,student_name,student_email);
    }

}
