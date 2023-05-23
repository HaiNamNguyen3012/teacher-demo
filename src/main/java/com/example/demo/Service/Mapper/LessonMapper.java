package com.example.demo.Service.Mapper;

import com.example.demo.DTO.LessonDto;
import com.example.demo.Model.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public interface LessonMapper extends EntityMapper<LessonDto, Lesson> {
}