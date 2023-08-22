package com.example.subject.Services.SeanceService;

import com.example.subject.Entities.Seance;
import com.example.subject.Entities.Subject;
import com.example.subject.dto.Seancedto;
import com.example.subject.dto.Subjectdto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ISeanceService {
    ResponseEntity<String> addSeance(Seancedto seance);
    String removeSeance(Long id);
    Optional<Seance> getSeanceById(Long id);

    Seance Modify (Long id,Seance seance);

    List<Seance> getSeanceBySubject(Long id);
}
