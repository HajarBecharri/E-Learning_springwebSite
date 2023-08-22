package com.example.User.services.TeacherService;

import com.example.User.Student;
import com.example.User.Teacher;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {

    String removeTeacherById(Long id);

    Teacher Modify(Long id, Teacher teacher);
    Optional<Teacher> getTeacherById(Long id);
    List <Teacher> SearchTeachersByAlias(String alias);
    List <Teacher> GetTeachers();

    String CreateQuiz();
}
