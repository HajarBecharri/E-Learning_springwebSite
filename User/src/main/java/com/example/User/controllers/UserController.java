package com.example.User.controllers;

import com.example.User.User;
import com.example.User.services.AdminService.IAdminService;
import com.example.User.services.TeacherService.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users/Admin")
public class UserController {

    @Autowired
    private IAdminService service;

    @GetMapping(path = "/AllUsers")

    public List<User> GetUsers(){
        return service.AllUsers();

    }
}
