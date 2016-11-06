package hello.controller;

import hello.dao.StudentRepository;
import hello.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @RequestMapping("/create")
    public Student createStudent(@RequestParam(value = "firstName", defaultValue = "null") String firstName,
                                 @RequestParam(value = "lastName", defaultValue = "null")String lastName) {

        Student student = new Student(firstName, lastName);
        repository.save(student);
        return student;
    }

    @RequestMapping("/find")
    public List<Student> findByFirstName(@RequestParam(value = "firstName", defaultValue = "null") String firstName){
        return repository.findByFirstName(firstName);
    }
}
