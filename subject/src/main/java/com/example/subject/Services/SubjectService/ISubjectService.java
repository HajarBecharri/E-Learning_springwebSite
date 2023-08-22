package com.example.subject.Services.SubjectService;

import com.example.subject.Entities.Subject;
import com.example.subject.dto.Seancedto;
import com.example.subject.dto.Subjectdto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {

    ResponseEntity<String> addSubject(Subjectdto subject);
    String removeSubjectById(Long id);
    Optional<Subject> getSubjectById(Long id);

    List <Subject> getSubjectByClass(Long id);
    List <Subject> getSubjectByTeacher(Long id);


}
