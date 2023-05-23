package com.example.demo.Service;

import com.example.demo.Common.CommonStatus;
import com.example.demo.DTO.LessonDto;
import com.example.demo.Model.Lesson;
import com.example.demo.Repository.LessonRepository;
import com.example.demo.Service.Mapper.LessonMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    private final LessonMapper lessonMapper;

    //get lesson by id
    public Lesson getLessonByID(Long id){
        Lesson lesson = lessonRepository.findById(id).get();
        LessonDto lessonDto = lessonMapper.toDto(lesson);
        return lesson;
    }

    //get all lesson
    public List<Lesson> getAllLessons(){return lessonRepository.findAll();}

    //delete lesson
    public CommonStatus deleteSubject(Long id){
        lessonRepository.findById(id);

        lessonRepository.deleteById(id);
        CommonStatus commonStatus = new CommonStatus();
        commonStatus.setStatus("200");
        commonStatus.setResponse("200");
        return commonStatus;
    }

    //save lesson
    public CommonStatus saveLesson(LessonDto lessonDto){
        Lesson lesson = lessonMapper.toEntity(lessonDto);
        lessonRepository.save(lesson);
        CommonStatus commonStatus = new CommonStatus();
        commonStatus.setStatus("200");
        commonStatus.setResponse("200");
        return commonStatus;
    }
}
