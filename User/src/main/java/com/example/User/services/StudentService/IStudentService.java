package com.example.User.services.StudentService;

import com.example.User.Student;
import com.example.User.Teacher;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    String removeStudentById(Long id);

    Student Modify(Long id,Student student);
    Optional<Student> getStudentById(Long id);
    List <Student> SearchStudentsByAlias(String alias);
    List <Student> GetStudents();




}
