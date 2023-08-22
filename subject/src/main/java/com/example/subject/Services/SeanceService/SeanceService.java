package com.example.subject.Services.SeanceService;

import com.example.subject.Entities.Seance;
import com.example.subject.Entities.Subject;
import com.example.subject.Repositories.SeanceRepo;
import com.example.subject.Repositories.SubjectRepo;
import com.example.subject.dto.Seancedto;
import com.example.subject.dto.Subjectdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class SeanceService implements  ISeanceService {
    @Autowired
    private final SeanceRepo repo;
    @Override
    public ResponseEntity<String> addSeance(Seancedto s) {
        Seance se =new Seance() ;
        se.setTitle(s.getTitle());
        se.setLocation(s.getLocation());
        se.setStartTime(s.getEndTime());
        se.setEndTime(s.getEndTime());
        se.setSubject(s.getS());
        Seance savedSeance=repo.save(se);


        if (savedSeance.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Seance created successfully with ID: " + savedSeance.getId());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create Seance");
        }
    }


    @Override
    public String removeSeance(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Class is deleted it";
        }
        else{
            return "Class not exist";
        }
    }

    @Override
    public Optional<Seance> getSeanceById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Seance Modify(Long id,Seance seance) {
        return repo.findById(id).map(s -> {
           s.setTitle(seance.getTitle());
           s.setLocation(seance.getLocation());
           s.setEndTime(seance.getEndTime());
           s.setStartTime(seance.getStartTime());

            return repo.save(s);
        }).orElseThrow(() -> new RuntimeException("Student Not Found"));
    }


    @Override
    public List<Seance> getSeanceBySubject(Long id) {
        return repo.findBySubjectId(id);
    }
}
