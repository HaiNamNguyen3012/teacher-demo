package com.example.demo.Service.Mapper;

import com.example.demo.DTO.TeacherDto;
import com.example.demo.Model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TeacherMapper  extends EntityMapper<TeacherDto, Teacher>{
}
