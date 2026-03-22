package com.shuni.homework2_mybatis.service.impl;

import com.shuni.homework2_mybatis.model.dto.request.InstructorRequest;
import com.shuni.homework2_mybatis.model.entity.Instructor;
import com.shuni.homework2_mybatis.repository.InstructorRepository;
import com.shuni.homework2_mybatis.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{
    private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> getAllInstructors(Integer page, Integer size) {
        return instructorRepository.findAllInstructors();
    }

    @Override
    public Instructor getInstructorById(Integer instructorId) {
        return instructorRepository.findInstructorById(instructorId);
    }

    @Override
    public Instructor createInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.saveInstructor(instructorRequest);
    }

    @Override
    public Instructor updateInstructorById(Integer instructorId, InstructorRequest instructorRequest) {
        return instructorRepository.updateInstructorById(instructorId, instructorRequest);
    }

    @Override
    public Instructor deleteInstructorById(Integer instructorId) {
        return instructorRepository.deleteInstructorById(instructorId);
    }
}
