package com.example.subject.Services.SubjectService;

import com.example.subject.Entities.Subject;
import com.example.subject.Repositories.SubjectRepo;
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
public class SubjectService implements ISubjectService{

    @Autowired
    private final SubjectRepo repo;
    @Override
    public String removeSubjectById(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Class is deleted it";
        }
        else{
            return "Class not exist";
        }
    }



    @Override
    public ResponseEntity<String> addSubject(Subjectdto s) {

        Subject sb =new Subject() ;
        sb.setName(s.getName());
        sb.setClass_id(s.getClass_id());
        sb.setId_Teacher(s.getId_Teacher());
        Subject savedSubject= repo.save(sb);


        if (savedSubject.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Subject created successfully with ID: " + savedSubject.getId());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create subject");
        }
    }


    @Override
    public Optional <Subject>  getSubjectById(Long id) {
        return repo.findById(id);
    }



    @Override
    public List<Subject> getSubjectByClass(Long id) {
        return repo.findByClassId(id);
    }

    @Override
    public List<Subject> getSubjectByTeacher(Long id) {
        return repo.findByTeacherId(id);
    }
}
