package com.example.User.repositories;

import com.example.User.Student;
import com.example.User.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    Teacher findFirstByEmail(String email);
    @Query("SELECT t FROM Teacher t WHERE t.name LIKE %:alias% OR t.email LIKE %:alias%")
    List<Teacher> searchByAlias(String alias);
}