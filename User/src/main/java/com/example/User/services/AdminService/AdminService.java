package com.example.User.services.AdminService;

import com.example.User.User;
import com.example.User.dto.QuizData;
import com.example.User.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AdminService implements  IAdminService{

    private final UserRepository userRep;

    @Override
    public List<User> AllUsers() {
        return userRep.findAll() ;
    }
}
