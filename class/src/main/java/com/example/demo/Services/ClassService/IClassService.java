package com.example.demo.Services.ClassService;

import com.example.demo.Models.Level;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.CreatCl;

import java.util.Optional;

public interface IClassService {

    String removeClassById(Long id);

    CreatCl AddClass(ClassDTO c);

    //method we need it to build getClassBySetud that will be in the user micro

    Optional<Level> getClassById(Long id);

}
