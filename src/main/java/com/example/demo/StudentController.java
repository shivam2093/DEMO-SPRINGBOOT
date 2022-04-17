package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    //means this studentService
    //autowired for us means
    //student service automatically
    //instantiate for us
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();
    }
    @PostMapping
    public void register(@RequestBody Student st){
        studentService.addNewStudent(st);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id
    ,@RequestParam(required = false) String name){
        studentService.updateStudent(id,name);
    }


}
