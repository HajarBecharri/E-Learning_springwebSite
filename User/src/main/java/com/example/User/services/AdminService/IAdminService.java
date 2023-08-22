package com.example.User.services.AdminService;

import com.example.User.User;
import com.example.User.dto.QuizData;

import java.util.List;

public interface IAdminService {
    List<QuizData> GetAll();
    List<QuizData> GetDataBySeanceId(Long id);

    List<QuizData> GetDataByChapId(Long id) ;

    List <User> AllUsers();

}
