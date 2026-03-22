package com.shuni.homework2_mybatis.service;

import com.shuni.homework2_mybatis.model.dto.request.StudentRequest;
import com.shuni.homework2_mybatis.model.entity.Student;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents(@Min(1) Integer page, @Max(10) Integer size);

    Student getStudentById(Integer studentId);

    Student createStudent(StudentRequest studentRequest);
    Student updateStudentById(Integer studentId, StudentRequest studentRequest);

    Student deleteStudentById(Integer studentId);
}
