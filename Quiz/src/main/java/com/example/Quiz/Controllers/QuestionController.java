package com.example.Quiz.Controllers;

import com.example.Quiz.Services.QuestionService.IQuestionService;
import com.example.Quiz.Services.QuizService.IQuizService;
import com.example.Quiz.dto.reqDTO;
import com.example.Quiz.entities.Question;
import com.example.Quiz.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Quiz/questions")
public class QuestionController {

    @Autowired
    private IQuestionService service;

    @DeleteMapping (path = "/remove/{id}")
    public String DeleteQuestion(@PathVariable Long id){
        return service.removeQuestion(id);
    }

    @GetMapping(path = "/quiz/{id}")
    public List<Question> findByQuiz(@PathVariable Long id){
        return service.getQuestionsByQuiz(id);
    }
}
