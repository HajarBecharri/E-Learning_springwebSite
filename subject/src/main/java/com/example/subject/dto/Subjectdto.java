package com.example.subject.dto;

import com.example.subject.Entities.Seance;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Collection;

@Data
public class Subjectdto {
    private String name;
    private Long id_Teacher;
    private Long class_id;
}
