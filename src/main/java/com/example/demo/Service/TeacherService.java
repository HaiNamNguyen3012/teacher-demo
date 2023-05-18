package com.example.demo.Service;

import com.example.demo.Common.CommonStatus;
import com.example.demo.DTO.TeacherDto;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.TeacherRepository;
import com.example.demo.Service.Mapper.TeacherMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@Transactional
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    public Teacher getTeacherByID(Long id){
        Teacher teacher = teacherRepository.findById(id).get();
//        System.out.println(teacher);
//        TeacherDto teacherDto = teacherMapper.toDto(teacher);
        return teacher;
    }

    public CommonStatus deleteTeacher(Long id){
        teacherRepository.findById(id);

        teacherRepository.deleteById(id);
        CommonStatus commonStatus = new CommonStatus();
        commonStatus.setStatus("200");
        commonStatus.setResponse("200");
        return commonStatus;
    }
}
