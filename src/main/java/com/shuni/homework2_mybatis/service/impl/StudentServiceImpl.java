package com.shuni.homework2_mybatis.service.impl;

import com.shuni.homework2_mybatis.model.dto.request.StudentRequest;
import com.shuni.homework2_mybatis.model.entity.Student;
import com.shuni.homework2_mybatis.repository.StudentRepository;
import com.shuni.homework2_mybatis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents(Integer page, Integer size) {
        return studentRepository.findAllStudents();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findStudentById(studentId);
    }

    @Override
    public Student createStudent(StudentRequest studentRequest) {
        return null;
    }
//
//    @Override
//    public Student createStudent(StudentRequest studentRequest) {
//        return studentRepository.saveStudent(studentRequest);
//    }

    @Override
    public Student updateStudentById(Integer studentId, StudentRequest studentRequest) {
        return studentRepository.updateStudentById(studentId ,studentRequest);
    }

    @Override
    public Student deleteStudentById(Integer studentId) {
        return studentRepository.deleteStudentById(studentId);
    }
}
