package com.example.subject.Services.SupportService;

import com.example.subject.Entities.CourseSupport;
import com.example.subject.Entities.Subject;
import com.example.subject.dto.Subjectdto;
import com.example.subject.dto.Supportdto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ISupportService {
    ResponseEntity<String> addSupport(Supportdto support);
    String removeSupportById(Long id);

    List<CourseSupport> getSupoortBySeance(Long id);
}
