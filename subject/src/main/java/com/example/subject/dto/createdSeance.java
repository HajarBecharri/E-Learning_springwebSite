package com.example.subject.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class createdSeance {

    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
}
