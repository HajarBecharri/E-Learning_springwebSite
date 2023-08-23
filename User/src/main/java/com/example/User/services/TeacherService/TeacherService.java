package com.example.User.services.TeacherService;

import com.example.User.Student;
import com.example.User.Teacher;
import com.example.User.repositories.StudentRepo;
import com.example.User.repositories.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService implements ITeacherService{
    @Autowired
    private final TeacherRepo teacherRepo ;

    @Override
    public String removeTeacherById(Long id) {
        if(teacherRepo.existsById(id)){
            teacherRepo.deleteById(id);
            return "Student is deleted it";
        }
        else{
            return "Student not exist";
        }
    }

    @Override
    public Teacher Modify(Long id, Teacher teacher) {
        return teacherRepo.findById(id).map(t -> {
            t.setName(teacher.getName());
            t.setEmail(teacher.getEmail());
            t.setSpeciality(teacher.getSpeciality());
            t.setAffectationDate(teacher.getAffectationDate());
            t.setPassword(teacher.getPassword());
            return teacherRepo.save(t);
        }).orElseThrow(() -> new RuntimeException("Teacher Not Found"));
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepo.findById(id);
    }

    @Override
    public List<Teacher> SearchTeachersByAlias(String alias) {
        return teacherRepo.searchByAlias(alias);
    }


    @Override
    public List<Teacher> GetTeachers() {
        return teacherRepo.findAll();
    }


}
