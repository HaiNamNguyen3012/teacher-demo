package com.example.demo.Service;

import com.example.demo.Common.CommonStatus;
import com.example.demo.DTO.SubjectDto;
import com.example.demo.Model.Subject;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.SubjectRepository;
import com.example.demo.Service.Mapper.SubjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;

    //get subject by id
    public Subject getSubjectByID(Long id){
        Subject subject = subjectRepository.findById(id).get();
        SubjectDto subjectDto = subjectMapper.toDto(subject);
        return subject;
    }

    //get all subject
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    //delete subject
    public CommonStatus deleteSubject(Long id){
        subjectRepository.findById(id);

        subjectRepository.deleteById(id);
        CommonStatus commonStatus = new CommonStatus();
        commonStatus.setStatus("200");
        commonStatus.setResponse("200");
        return commonStatus;
    }

    //save subject
    public CommonStatus saveSubject(SubjectDto subjectDto){
        Subject subject = subjectMapper.toEntity(subjectDto);
        subjectRepository.save(subject);
        CommonStatus commonStatus = new CommonStatus();
        commonStatus.setResponse("200");
        commonStatus.setStatus("200");
        return commonStatus;
    }
}
