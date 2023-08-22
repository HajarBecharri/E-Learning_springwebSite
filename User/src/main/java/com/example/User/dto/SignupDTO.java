package com.example.User.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SignupDTO {
    private String name;

    private String email;

    private String password;

    private String role;

    private Integer class_id;

    private Date affectationDate;

    private String speciality;


}
