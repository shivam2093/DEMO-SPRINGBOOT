package com.example.demo;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Table(name="student")
@Entity(name="Student")
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name= "id",
            updatable = false,
            nullable = false)
    private Long id;
    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    private LocalDate dob;
    //we dont need column for the age
    //means iy gets calculate first
    @Transient
    private Integer age;

    public Student(Long id,String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;

    }

    public Student() {

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
