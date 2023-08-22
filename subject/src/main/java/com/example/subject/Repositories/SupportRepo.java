package com.example.subject.Repositories;

import com.example.subject.Entities.CourseSupport;
import com.example.subject.Entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportRepo extends JpaRepository<CourseSupport,Long> {


    List<CourseSupport> findBySeanceId(Long SeanceId);
}
