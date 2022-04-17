package com.example.demo;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
//        System.out.print(student);
   }

    public void deleteStudent(Long id) {

//    studentRepository.deleteById(st.getId());
    boolean exists = studentRepository.existsById(id);
    if(!exists){
        throw new IllegalStateException("student" +
                id + "not exists" );
    }else{
        studentRepository.deleteById(id);
        }
    }
    @Transactional
    public void updateStudent(Long id, String name) {
        //boolean exists = studentRepository.existsById(id);
//
       Student st = studentRepository.findById(id)
               .orElseThrow(() ->
                       new IllegalStateException(
              "student" + id + "doesn't exist"
                       ));

        
            if (name != null && name.length() > 0 &&
                    !Objects.equals(st.getName(), name) && st.getId() == id) {
                st.setName(name);
            }


    }}
