package com.example.subject.Controllers.SeanceController;



import com.example.subject.Entities.Seance;
import com.example.subject.Services.SeanceService.ISeanceService;
import com.example.subject.dto.Seancedto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Subjects/Seance")
public class SeanceController {

    @Autowired
    private ISeanceService service;

    @GetMapping (path = "/findSeance/{id}")
    public Optional<Seance> findById(@PathVariable Long id){
        return service.getSeanceById(id);
    }
    @DeleteMapping(path = "/remove/{id}")
    public String removeSeanceById(@PathVariable Long id){
        return service.removeSeance(id);
    }
    @PutMapping(path = "/Modify")
    public Seance ModifySeance(@RequestBody Seance S){
        Long id=S.getId();
        return service.Modify(id,S);
    }

    @GetMapping (path = "/findSeanceBySubject/{id}")
    public ResponseEntity<List<Seance>> findBySubject(@PathVariable Long id){
        List<Seance> seances = service.getSeanceBySubject(id);
        return ResponseEntity.ok(seances);
    }

    @PostMapping (path = "/addSeance")
    public ResponseEntity<String> findByClass(@RequestBody Seancedto s){
        return service.addSeance(s);
    }
}
