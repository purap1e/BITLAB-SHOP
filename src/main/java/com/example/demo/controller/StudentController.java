package com.example.demo.controller;

import com.example.demo.DBManager;
import com.example.demo.service.StudentService;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
@org.springframework.stereotype.Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
//
//    @GetMapping
//    public List<Student> getStudents(){
//        return service.getStudents();
//    }

    @GetMapping(value = "/index")
    public String index(Model model){

        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("students", students);

        return "index";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "name") String name,
                             @RequestParam(name = "email") String email,
                             @RequestParam(name = "age") int age){

        DBManager.addStudent(new Student(null,name,email,age));
        return "redirect:/index";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id){

        Student student = DBManager.getStudent(id);
        model.addAttribute("student", student);

        return "details";
    }
}
