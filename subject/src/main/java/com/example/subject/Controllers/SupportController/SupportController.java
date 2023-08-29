package com.example.subject.Controllers.SupportController;

import com.example.subject.Entities.CourseSupport;

import com.example.subject.Services.SupportService.ISupportService;
import com.example.subject.dto.Supportdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/Subjects/support")
public class SupportController {

    @Autowired
    private ISupportService service;

    @GetMapping (path = "/findBySeance/{id}")
    public List<CourseSupport> findById(@PathVariable Long id){
        return service.getSupoortBySeance(id);
    }
    @DeleteMapping(path = "/remove/{id}")
    public String removeSupportById(@PathVariable Long id){
        return service.removeSupportById(id);
    }

    @PostMapping (path = "/addSupport")
    public ResponseEntity<String> addSupport(@RequestBody Supportdto s){
        return service.addSupport(s);
    }
}


