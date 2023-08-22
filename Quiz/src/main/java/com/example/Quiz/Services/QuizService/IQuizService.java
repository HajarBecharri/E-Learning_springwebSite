package com.example.Quiz.Services.QuizService;

import com.example.Quiz.dto.reqDTO;
import com.example.Quiz.entities.Quiz;

import java.util.List;

public interface IQuizService {
    List<Quiz> getQuizBySeance(Long SeanceId);
    Quiz setQuiz(reqDTO req);
}
