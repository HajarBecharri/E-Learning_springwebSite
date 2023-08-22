package com.example.subject.Repositories;

import com.example.subject.Entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceRepo extends JpaRepository<Seance,Long> {
    List<Seance> findBySubjectId(Long SubjectId);
}
