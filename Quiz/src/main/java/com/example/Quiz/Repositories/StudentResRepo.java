package com.example.Quiz.Repositories;

import com.example.Quiz.entities.Student_Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentResRepo extends JpaRepository<Student_Response,Long> {
    List<Student_Response> findByQuizIdAndStudentId(Long quizId, Long studentId);
    List<Student_Response> findByQuizId(Long quizId);

}
