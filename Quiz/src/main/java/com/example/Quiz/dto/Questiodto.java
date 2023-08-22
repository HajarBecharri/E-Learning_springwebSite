package com.example.Quiz.dto;

import com.example.Quiz.entities.Question;
import com.example.Quiz.entities.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questiodto {

    private String text;
    private Quiz quiz;
}
