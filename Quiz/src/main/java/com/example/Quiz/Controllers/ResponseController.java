package com.example.Quiz.Controllers;


import com.example.Quiz.Services.QuizService.IQuizService;
import com.example.Quiz.Services.ResponseService.IResponseService;
import com.example.Quiz.dto.reqDTO;
import com.example.Quiz.entities.Quiz;
import com.example.Quiz.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Quiz/Response")
public class ResponseController {

    @Autowired
    private IResponseService service;

    @GetMapping(path = "/findResponseByQuest/{id}")
    public Response findByByQuest(@PathVariable Long id) {
        return service.getResByQuest(id);
    }
}


