package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SubjectDto {
    private Long id;

    private String name;

    private int grade;

    private Long lessonID;
}
