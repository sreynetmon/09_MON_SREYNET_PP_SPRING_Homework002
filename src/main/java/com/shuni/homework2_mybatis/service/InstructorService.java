package com.shuni.homework2_mybatis.service;

import com.shuni.homework2_mybatis.model.dto.request.InstructorRequest;
import com.shuni.homework2_mybatis.model.entity.Instructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(@Min(1) Integer page, @Max(10) Integer size);

    Instructor getInstructorById(Integer instructorId);

    Instructor createInstructor(InstructorRequest instructorRequest);

    Instructor updateInstructorById(Integer instructorId, InstructorRequest instructorRequest);

    Instructor deleteInstructorById(Integer instructorId);
}
