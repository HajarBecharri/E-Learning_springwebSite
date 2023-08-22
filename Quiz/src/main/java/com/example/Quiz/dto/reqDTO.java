package com.example.Quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class reqDTO {
    private List <Quizdto> Quiz;
    private Long id_Module;
}
