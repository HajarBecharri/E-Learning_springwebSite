package com.example.Quiz.Services.QuestionService;

import com.example.Quiz.dto.Questiodto;
import com.example.Quiz.entities.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IQuestionService {

    Question addQuestion(Questiodto quest);
    String removeQuestion(Long questId);

    List <Question> getQuestionsByQuiz(Long quizId);
}
