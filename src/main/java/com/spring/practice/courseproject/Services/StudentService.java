package com.spring.practice.courseproject.Services;

import com.spring.practice.courseproject.Exceptions.*;
import com.spring.practice.courseproject.Model.Student;
import com.spring.practice.courseproject.Repositorys.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
//postgres password:parola
//student password:parola


//@Component
@Service//same thing as @Component but it's about semantics...
public class StudentService {

    private final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public void addNewStudent(Student student) throws emailAlreadyExistsException, InvalidEmailException {
        Optional<Student> studentByEmail = repo.getStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new emailAlreadyExistsException();
        }
        String regex="[A-Za-z-._$*]*@[a-z.]*(com)$";
        Pattern pattern = Pattern.compile(regex);
        if(!pattern.matcher(student.getEmail()).matches()){
            throw new InvalidEmailException();
        }
        repo.save(student);

    }

    public void deleteStudent(Long id) throws UserDoesNotExists {
        if(repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new UserDoesNotExists(id);
        }
    }
    @Transactional//it means that I don't have to implement any jpql query, I can use the setters from my entity to check if I can or cannot update and then use the setters to automaticaly update the entity in the db
    public void updateStudent(Long student_id, String student_name, String student_email) throws UserDoesNotExists, InvalidEmailException, emailAlreadyExistsException {

        Student student = repo.findById(student_id)
                .orElseThrow(() -> new UserDoesNotExists(student_id));

        if(student_name.length() > 0 && student_name != null && !student.getName().equals(student_name)){
            student.setName(student_name);
        }

        if(student_email.length()>0 && student_email != null && !student.getEmail().equals(student_email)){
           String regex="[A-Za-z-._$*]*@[a-z.]*(com)$";
           Pattern pattern = Pattern.compile(regex);
           if(!pattern.matcher(student_email).matches()){
                throw new InvalidEmailException();
           }
           Optional<Student> studentByEmail = repo.getStudentByEmail(student_email);
           if(studentByEmail.isPresent()){
                throw new emailAlreadyExistsException();
           }
           student.setEmail(student_email);
        }

    }
}
