package com.shuni.homework2_mybatis.service.impl;

import com.shuni.homework2_mybatis.model.dto.request.CourseRequest;
import com.shuni.homework2_mybatis.model.entity.Course;
import com.shuni.homework2_mybatis.repository.CourseRepository;
import com.shuni.homework2_mybatis.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        return courseRepository.findAllCourses();
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return courseRepository.findCourseById(courseId);
    }

    @Override
    public Course createNewCourse(CourseRequest courseRequest) {
        courseRepository.saveNewCourse(courseRequest);
        return courseRepository.findCourseById(courseRequest.getInstructorId());
    }

    @Override
    public Course updateCourseById(Integer courseId, CourseRequest courseRequest) {
        courseRepository.updateCourseById(courseId,courseRequest);
        return courseRepository.findCourseById(courseRequest.getInstructorId());
    }

    @Override
    public Course deleteCourseById(Integer courseId) {
        courseRepository.findCourseById(courseId);
        return courseRepository.deleteCourseById(courseId);
    }
}
