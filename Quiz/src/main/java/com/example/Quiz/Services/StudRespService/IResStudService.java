package com.example.Quiz.Services.StudRespService;

import com.example.Quiz.dto.Responsedto;
import com.example.Quiz.entities.Question;
import com.example.Quiz.entities.Student_Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IResStudService {

    ResponseEntity<String> addResStudent(Responsedto response);
    List<Integer> getNotesByQuiz(Long QuizId);
    int getNoteByQuizAndStudent(Long StudId,Long QuizId);




}
