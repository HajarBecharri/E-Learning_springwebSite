package com.example.User.repositories;

import com.example.User.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface StudentRepo extends JpaRepository<Student,Long> {
        Student findFirstByEmail(String email);
        @Query("SELECT s FROM Student s WHERE s.name LIKE %:alias% OR s.email LIKE %:alias%")
        List<Student> searchByAlias(String alias);
    }

