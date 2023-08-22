package com.example.subject.Services.SupportService;

import com.example.subject.Entities.CourseSupport;
import com.example.subject.Entities.Seance;
import com.example.subject.Entities.Subject;
import com.example.subject.Repositories.SupportRepo;
import com.example.subject.dto.Subjectdto;
import com.example.subject.dto.Supportdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupportService implements ISupportService {

    @Autowired
    private final SupportRepo repo;
    @Override
    public ResponseEntity<String> addSupport(Supportdto support) {
        CourseSupport cs =new CourseSupport() ;
        cs.setName(support.getName());
        cs.setDescription(support.getDescription());
        cs.setLink("");
        cs.setSeance(support.getS());

        CourseSupport savedSupport=repo.save(cs);


        if (savedSupport.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Seance created successfully with ID: " + savedSupport.getId());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create Seance");
        }
    }

    @Override
    public String removeSupportById(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Class is deleted it";
        }
        else{
            return "Class not exist";
        }
    }


    @Override
    public List<CourseSupport> getSupoortBySeance(Long id) {
        return repo.findBySeanceId(id);
    }
}
