package com.example.demo.controller;

import com.example.demo.Common.CommonStatus;
import com.example.demo.Common.DemoException;
import com.example.demo.DTO.SubjectDto;
import com.example.demo.Model.Subject;
import com.example.demo.Service.SubjectService;
import com.example.demo.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@AllArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    //Get Subject By ID
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectByID(@PathVariable Long id){
        return ResponseEntity.ok(subjectService.getSubjectByID(id));
    }

    //Get All Subject
    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects(){

        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    //Create Subject
    @PostMapping
    public ResponseEntity<CommonStatus> saveSubject(@RequestBody SubjectDto subjectDto){
        if(subjectDto.getId() != null) throw new DemoException("Tạo mới không được có id");
        return ResponseEntity.ok(subjectService.saveSubject(subjectDto));
    }

    //Update Subject
    @PutMapping("")
    public ResponseEntity<CommonStatus> updateSubject(@RequestBody SubjectDto subjectDto){
        if(subjectDto.getId() == null) throw new DemoException("Bắt buộc có ID");
        return ResponseEntity.ok(subjectService.saveSubject(subjectDto));
    }
    //Delete Subject
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonStatus> deleteSubject(@PathVariable Long id){
        return ResponseEntity.ok(subjectService.deleteSubject(id));
    }

}
