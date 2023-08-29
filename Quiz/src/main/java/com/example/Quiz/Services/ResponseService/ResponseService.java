package com.example.Quiz.Services.ResponseService;

import com.example.Quiz.Repositories.ResponseRepo;
import com.example.Quiz.dto.Responsedto;
import com.example.Quiz.entities.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponseService implements IResponseService {
    @Autowired
    private final ResponseRepo repo;
    @Override
    public ResponseEntity<String> addRes(Responsedto res) {
        Response se =new Response() ;
        se.setText(res.getText());
        se.setQuestion(res.getQuestion());
        Response savedRes=repo.save(se);


        if (savedRes.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Res created successfully with ID: " + savedRes.getId());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Res to create Seance");
        }
    }



    @Override
    public Response getResByQuest(Long questId) {
        return repo.findByQuestionId(questId);
    }

    @Override
    public String removeResponse(Long id) {

            if(repo.existsById(id)){
                repo.deleteById(id);
                return "Response is deleted it";
            }
            else{
                return "Response not exist";
            }

    }
}
