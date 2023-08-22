package com.example.Quiz.Services.QuizService;

import com.example.Quiz.Repositories.QuestionRepo;
import com.example.Quiz.Repositories.QuizRepo;
import com.example.Quiz.Services.QuestionService.QuestionService;
import com.example.Quiz.Services.ResponseService.ResponseService;
import com.example.Quiz.dto.Questiodto;
import com.example.Quiz.dto.Quizdto;
import com.example.Quiz.dto.Responsedto;
import com.example.Quiz.dto.reqDTO;
import com.example.Quiz.entities.Question;
import com.example.Quiz.entities.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizService implements IQuizService{

    @Autowired
    private final QuizRepo repo;
    @Autowired
    private final ResponseService resService;
    @Autowired
    private final QuestionService questService;
    @Override
    public List<Quiz> getQuizBySeance(Long SeanceId) {
        return repo.findBySeanceId(SeanceId);
    }

    @Override
    public Quiz setQuiz(reqDTO req) {
        Quiz quiz =new Quiz() ;
        quiz.setSeance_id(req.getId_Module());
        Quiz savedQuiz=repo.save(quiz);
        Questiodto question =new Questiodto();
        List<Quizdto> All= req.getQuiz();
        for (Quizdto quizdto : All) {
            String Question =quizdto.getQuestion();
            String Response =quizdto.getResponse();
            Questiodto quest = new Questiodto();
            quest.setQuiz(savedQuiz);
            quest.setText(Question);
            Question savedQuest=questService.addQuestion(quest);
            Responsedto res =new Responsedto();
            res.setText(Response);
            res.setQuestion(savedQuest);

            resService.addRes(res);
        }


        return quiz;
    }
}
