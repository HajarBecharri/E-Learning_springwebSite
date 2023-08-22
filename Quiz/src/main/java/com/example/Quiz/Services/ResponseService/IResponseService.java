package com.example.Quiz.Services.ResponseService;

import com.example.Quiz.dto.Responsedto;
import com.example.Quiz.entities.Question;
import com.example.Quiz.entities.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IResponseService {
    ResponseEntity<String> addRes(Responsedto res);

    Response getResByQuest(Long questId);

    String removeResponse(Long id);
}
