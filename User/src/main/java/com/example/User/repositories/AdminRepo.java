package com.example.User.repositories;

import com.example.User.Admin;
import com.example.User.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
    Student findFirstByEmail(String email);
}
