package com.example.Quiz.Controllers;

import com.example.Quiz.Services.QuizService.IQuizService;
import com.example.Quiz.dto.reqDTO;
import com.example.Quiz.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Quiz/quiz")
public class QuizController {

    @Autowired
    private IQuizService service;

    @GetMapping (path = "/findQuizByModule/{id}")
    public ResponseEntity<List<Quiz>> findBySubject(@PathVariable Long id){
        List<Quiz> quizs = service.getQuizBySeance(id);
        return ResponseEntity.ok(quizs);
    }

    @PostMapping (path = "/addQuiz")
    public Quiz addQuiz(@RequestBody reqDTO req){
        return service.setQuiz(req);
    }
}
