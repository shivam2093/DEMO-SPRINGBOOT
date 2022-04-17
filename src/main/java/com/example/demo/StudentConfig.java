package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repo){
        return args -> {

            Student maria =  new Student(1L,"maria",
                    LocalDate.of(1993,07,20)
                    );
         Student shiv =  new Student(2L,"shivam",
                    LocalDate.of(1993,07,20)
                    );
        repo.saveAll(List.of(maria,shiv));

        };
    }

}
