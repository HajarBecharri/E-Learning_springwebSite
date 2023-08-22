package com.example.User.controllers;

import com.example.User.Student;

import com.example.User.services.StudentService.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users/Student")
public class StudentController {

    @Autowired
    private IStudentService service;

    @GetMapping(path = "/findAll")

    public List<Student> findAll() {
        return service.GetStudents();

    }
    @GetMapping(path = "/search/{alias}")

    public List <Student> search(@PathVariable String alias){
        return service.SearchStudentsByAlias(alias);
    }
    @GetMapping (path = "/findStudent/{id}")
    public Optional<Student> findById(@PathVariable Long id){
        return service.getStudentById(id);
    }
    @DeleteMapping(path = "/remove/{id}")
    public String removeStudentById(@PathVariable Long id){
        return service.removeStudentById(id);
    }
    @PutMapping(path = "/Modify")
    public Student ModifyStudent(@RequestBody Student S){
        Long id=S.getId();
        return service.Modify(id,S);
    }
}