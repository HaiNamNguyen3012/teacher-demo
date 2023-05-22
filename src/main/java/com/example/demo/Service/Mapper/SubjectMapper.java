package com.example.demo.Service.Mapper;


import com.example.demo.DTO.SubjectDto;
import com.example.demo.Model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SubjectMapper extends EntityMapper <SubjectDto, Subject>{

}
