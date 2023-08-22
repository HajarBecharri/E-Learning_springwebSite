package com.example.subject.dto;

import com.example.subject.Entities.Subject;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Seancedto  {

    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private Subject s;
}
