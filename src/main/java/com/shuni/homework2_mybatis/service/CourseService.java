package com.shuni.homework2_mybatis.service;

import com.shuni.homework2_mybatis.model.dto.request.CourseRequest;
import com.shuni.homework2_mybatis.model.entity.Course;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(@Min(1) Integer page, @Max(10) Integer size);

    Course getCourseById(Integer courseId);

    Course createNewCourse(CourseRequest courseRequest);

    Course updateCourseById(Integer courseId, CourseRequest courseRequest);

    Course deleteCourseById(Integer courseId);
}


