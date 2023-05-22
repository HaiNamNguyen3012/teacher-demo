package com.example.demo.controller;

import com.example.demo.Common.CommonStatus;
import com.example.demo.Common.DemoException;
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
    public ResponseEntity<CommonStatus> saveTeacher (@RequestBody TeacherDto teacherDto){
        if(teacherDto.getId() != null) throw new DemoException("Tạo mới không được có id");
        return ResponseEntity.ok(teacherService.saveTeacher(teacherDto));
    }

    //Update Teacher
    @PutMapping("")
    public ResponseEntity<CommonStatus> updateTeacher(@RequestBody TeacherDto teacherDto){
        if(teacherDto.getId() == null) throw new DemoException("Bắt buộc có ID");
        return ResponseEntity.ok(teacherService.saveTeacher(teacherDto));
    }

    //Delete Teacehr
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonStatus> deleteTeacher(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }
}
