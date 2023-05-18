package com.example.demo.controller;


import com.example.demo.Common.CommonStatus;
import com.example.demo.DTO.TeacherDto;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherByID (@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherByID(id));
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonStatus> deleteTeacher(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }
}
