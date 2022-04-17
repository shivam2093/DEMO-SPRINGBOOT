package com.example.demo;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent(){
       return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
   Optional<Student> studentByName = studentRepository.findStudentsByName(student.getName());
        if(studentByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
   studentRepository.save(student);
   }
}
