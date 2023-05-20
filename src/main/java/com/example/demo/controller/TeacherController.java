package com.example.demo.controller;


import com.example.demo.Common.CommonStatus;
import com.example.demo.DTO.TeacherDto;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    //Get Teacher By ID
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherByID (@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherByID(id));
    };

    //Get All Teacher
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }
    //Create Teacher
    @PostMapping
    public ResponseEntity<Teacher> createUser (@RequestBody CreateTeacherRequest request){
        Teacher createdTeacher = teacherService.createTeacher(request);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    //Update Teacher

    //Delete Teacehr
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonStatus> deleteTeacher(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }
}
