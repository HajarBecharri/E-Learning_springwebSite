package com.example.Quiz.Services.StudRespService;

import com.example.Quiz.Repositories.ResponseRepo;
import com.example.Quiz.Repositories.StudentResRepo;
import com.example.Quiz.Services.ResponseService.IResponseService;
import com.example.Quiz.dto.Responsedto;
import com.example.Quiz.entities.Response;
import com.example.Quiz.entities.Student_Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ResStudService implements IResStudService{
    @Autowired
    private final StudentResRepo repo;

    @Autowired
    private final IResponseService service;
    @Override
    public ResponseEntity<String> addResStudent(Responsedto response) {
        Student_Response se =new Student_Response() ;
        se.setStudentId(response.getStudent_id());
        se.setResponse(response.getText());
        se.setQuestion(response.getQuestion());
        se.setQuiz(response.getQuiz());
        Student_Response savedRes=repo.save(se);


        if (savedRes.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Response created successfully with ID: " + savedRes.getId());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create Response");
        }
    }


    @Override
    public List<Integer> getNotesByQuiz(Long QuizId) {
        List<Integer> list = new ArrayList<>();

        int counter;
        List <Student_Response> res = repo.findByQuizId(QuizId);
        Map<Long, Student_Response> uniqueStudentsMap = new LinkedHashMap<>(); // LinkedHashMap maintains insertion order

        for (Student_Response s : res) {
            uniqueStudentsMap.putIfAbsent(s.getStudentId(), s);
        }

        List<Student_Response> uniqueStudentsList = new ArrayList<>(uniqueStudentsMap.values());


        for(Student_Response StudRes:uniqueStudentsList){
            counter=this.getNoteByQuizAndStudent(StudRes.getStudentId(),QuizId);
            list.add(counter);
            counter=0;

        }
        return list;
    }



    @Override
    public int getNoteByQuizAndStudent(Long StudId, Long QuizId) {
        List <Student_Response> res = repo.findByQuizIdAndStudentId(QuizId,StudId);

        int Counter= 0;
        for (Student_Response StudRes: res){
            Response response =service.getResByQuest(StudRes.getQuestion().getId());
            if(response.getText().equalsIgnoreCase(StudRes.getResponse())){
                Counter++;
            }
        }
        return Counter;

    }


}
