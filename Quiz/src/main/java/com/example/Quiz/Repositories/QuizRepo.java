package com.example.Quiz.Repositories;

import com.example.Quiz.entities.Quiz;
import com.example.Quiz.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Long> {
    @Query("SELECT q FROM Quiz q WHERE q.Seance_id = :SeanceId")
    List<Quiz> findBySeanceId(Long SeanceId);
}

