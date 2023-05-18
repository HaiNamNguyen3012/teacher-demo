package com.example.demo.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TeacherDto {
    private Long id;

    private String name;

    private int age;

    private Long  subjectId;

    private String image;
}
