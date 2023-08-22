package com.example.demo;


import com.example.demo.Models.Level;
import com.example.demo.Services.ClassService.IClassService;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.CreatCl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/levels")
public class ClassController {

    @Autowired
    private IClassService service;

    @GetMapping (path = "/findClass/{id}")
    public Optional<Level> findById(@PathVariable Long id){
        return service.getClassById(id);
    }
    @DeleteMapping(path = "/remove/{id}")
    public String removeStudentById(@PathVariable Long id){
        return service.removeClassById(id);
    }

    @PostMapping(path="/add")
    public ResponseEntity<?> signupUser(@RequestBody ClassDTO c) {
        CreatCl cl = service.AddClass(c);
        if (cl== null){
            return new ResponseEntity<>("Class not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cl, HttpStatus.CREATED);
    }
}
