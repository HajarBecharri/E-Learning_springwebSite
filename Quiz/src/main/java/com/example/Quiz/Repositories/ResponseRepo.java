package com.example.Quiz.Repositories;

import com.example.Quiz.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepo extends JpaRepository<Response,Long> {
    Response findByQuestionId(Long QuestId);
}


