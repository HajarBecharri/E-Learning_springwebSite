package com.example.subject.dto;

import com.example.subject.Entities.Seance;
import lombok.Data;

@Data
public class Supportdto {

    private Long id;
    private Long seance_id;
    private Seance s ;
    private String name;
    private String description;
}
