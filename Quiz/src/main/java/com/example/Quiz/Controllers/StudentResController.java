package com.example.Quiz.Controllers;

import com.example.Quiz.Services.ResponseService.IResponseService;
import com.example.Quiz.Services.StudRespService.IResStudService;
import com.example.Quiz.dto.Responsedto;
import com.example.Quiz.dto.reqDTO;
import com.example.Quiz.entities.Quiz;
import com.example.Quiz.entities.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/Quiz/Response/Student")
public class StudentResController {
    @Autowired
    private IResStudService service;

    @GetMapping(path = "/notes/Quiz/{id}")
    public List<Integer> findByQuiz(@PathVariable Long id) {
        return service.getNotesByQuiz(id);
    }


    @PostMapping(path = "/add/Student/Response")
    public ResponseEntity<String> addQuizResponse(@RequestBody Responsedto res) {
        return service.addResStudent(res);

    }
    @PostMapping(path = "/add/StudentRes/Quiz")
    public String addQuizResponces(@RequestBody List<Responsedto> res) {
        for(Responsedto response:res){ service.addResStudent(response);}

        return "done";


    }

    @GetMapping(path = "/note/Quiz/Student/{id_quiz}/{id_Student}")
    public int addQuiz(@PathVariable Long id_quiz,@PathVariable Long id_Student) {
        return service.getNoteByQuizAndStudent(id_Student,id_quiz);

    }
}
