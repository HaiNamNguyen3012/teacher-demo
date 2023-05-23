package com.example.demo.controller;

import com.example.demo.Common.CommonStatus;
import com.example.demo.Common.DemoException;
import com.example.demo.DTO.LessonDto;
import com.example.demo.Model.Lesson;
import com.example.demo.Service.LessonService;
import com.example.demo.Service.Mapper.LessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
@AllArgsConstructor
public class LessonController {
    private final LessonService lessonService;
    private final LessonMapper lessonMapper;

    //Get Lesson By ID
    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonByID(@PathVariable Long id){
        return ResponseEntity.ok(lessonService.getLessonByID(id));
    }

    //Get All Lesson
    @GetMapping
    public ResponseEntity<List<Lesson>> getAllLessons(){
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    //Create Lesson
    @PostMapping
    public ResponseEntity<CommonStatus> saveLesson(@RequestBody LessonDto lessonDto){
        if(lessonDto.getId() != null) throw new DemoException("Tạo mới không được có id");
        return ResponseEntity.ok(lessonService.saveLesson(lessonDto));
    }

    //Update Subject
    @PutMapping
    public ResponseEntity<CommonStatus> saveLessons(LessonDto lessonDto){
        if(lessonDto.getId() == null) throw new DemoException("Bắt buộc có ID");
        return ResponseEntity.ok(lessonService.saveLesson(lessonDto));
    }

    //Delete Subject
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonStatus> deleteSubject(@PathVariable Long id){
        return ResponseEntity.ok(lessonService.deleteLesson(id));
    }

}
