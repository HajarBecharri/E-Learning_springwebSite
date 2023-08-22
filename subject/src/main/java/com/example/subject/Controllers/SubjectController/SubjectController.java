package com.example.subject.Controllers.SubjectController;


import com.example.subject.Entities.Subject;
import com.example.subject.Services.SubjectService.ISubjectService;
import com.example.subject.dto.Subjectdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Subjects/subject")
public class SubjectController {

    @Autowired

    private ISubjectService service;

    @GetMapping (path = "/findSubject/{id}")
    public Optional<Subject> findById(@PathVariable Long id){
        return service.getSubjectById(id);
    }
    @DeleteMapping(path = "/remove/{id}")
    public String removeSubjecttById(@PathVariable Long id){
        return service.removeSubjectById(id);
    }

    @GetMapping (path = "/findSubjectByClass/{id}")
    public List<Subject> findByClass(@PathVariable Long id){
        return service.getSubjectByClass(id);
    }

    @PostMapping (path = "/addSubject")
    public ResponseEntity<String> add(@RequestBody Subjectdto s){
        return service.addSubject(s);
    }
    @GetMapping (path = "/findSubjectByTeacher/{id}")
    public List<Subject> findByTeacher(@PathVariable Long id) {
        return service.getSubjectByTeacher(id);
    }



}

