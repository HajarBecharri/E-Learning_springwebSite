package com.example.User.services.StudentService;

import com.example.User.Student;
import com.example.User.repositories.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{

    @Autowired
    private final StudentRepo studentRepo ;

    @Override
    public String removeStudentById(Long id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Student is deleted it";
        }
        else{
            return "Student not exist";
        }

    }

    @Override
    public Student Modify(Long id, Student student) {
        return studentRepo.findById(id).map(s -> {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setClass_id(student.getClass_id());
            s.setPassword(student.getPassword());
            return studentRepo.save(s);
        }).orElseThrow(() -> new RuntimeException("Student Not Found"));
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> SearchStudentsByAlias(String alias) {
        return studentRepo.searchByAlias(alias);
    }


    @Override
    public List<Student> GetStudents() {
        return studentRepo.findAll();
    }


}
