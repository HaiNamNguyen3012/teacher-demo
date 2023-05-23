package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class LessonDto {
    private Long id;

    private String title;

    private int grade;

    private String content;

    private String url;

    private Long subjectID;
}
