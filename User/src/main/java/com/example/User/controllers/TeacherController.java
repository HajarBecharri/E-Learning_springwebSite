package com.example.User.controllers;


import com.example.User.Student;


import com.example.User.Teacher;
import com.example.User.services.TeacherService.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users/Teacher")
public class TeacherController {

    @Autowired
    private ITeacherService service;

    @GetMapping(path = "/findAll")

    public List<Teacher> findAll() {
        return service.GetTeachers();

    }
    @GetMapping(path = "/search/{alias}")

    public List <Teacher> search(@PathVariable String alias){
        return service.SearchTeachersByAlias(alias);
    }
    @GetMapping (path = "/findTeacher/{id}")
    public Optional<Teacher> findById(@PathVariable Long id){
        return service.getTeacherById(id);
    }
    @DeleteMapping(path = "/remove/{id}")
    public String removeTeacherById(@PathVariable Long id){
        return service.removeTeacherById(id);
    }
    @PutMapping(path = "/Modify")
    public Teacher ModifyTeacher(@RequestBody Teacher S){
        Long id=S.getId();
        return service.Modify(id,S);
    }
}