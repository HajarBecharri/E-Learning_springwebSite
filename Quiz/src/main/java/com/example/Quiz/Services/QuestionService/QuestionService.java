package com.example.Quiz.Services.QuestionService;

import com.example.Quiz.Repositories.QuestionRepo;
import com.example.Quiz.Services.ResponseService.ResponseService;
import com.example.Quiz.dto.Questiodto;
import com.example.Quiz.dto.Responsedto;
import com.example.Quiz.entities.Question;
import com.example.Quiz.entities.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {
    @Autowired
    private final QuestionRepo repo;

    @Autowired
    private final ResponseService service;


    @Override
    public Question addQuestion(Questiodto quest) {
        Question se = new Question();
        se.setText(quest.getText());
        se.setQuiz(quest.getQuiz());
        Question savedQuestion = repo.save(se);

        return savedQuestion;
    }


    @Override
    public String removeQuestion(Long questId) {
        if(repo.existsById(questId)){
            Response res = service.getResByQuest(questId);
            service.removeResponse(res.getId()) ;// Update the response
            repo.deleteById(questId);
            return "Question is deleted it";
        }
        else{
            return "Question not exist";
        }
    }


    @Override
    public List<Question> getQuestionsByQuiz(Long quizId) {
        return repo.findByQuizId(quizId);
    }
}
