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
public class Responsedto {
    private String text;
    private Question question;
    private Long Student_id;
    private Quiz quiz;
}
