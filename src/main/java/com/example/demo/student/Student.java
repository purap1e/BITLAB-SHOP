package com.example.demo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "students")
public class Student {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int exam;
    private String mark;
}
