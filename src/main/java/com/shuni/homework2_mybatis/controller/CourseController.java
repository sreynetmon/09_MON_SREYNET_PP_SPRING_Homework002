package com.shuni.homework2_mybatis.controller;

import com.shuni.homework2_mybatis.model.dto.request.CourseRequest;
import com.shuni.homework2_mybatis.model.dto.response.ApiResponse;
import com.shuni.homework2_mybatis.model.entity.Course;
import com.shuni.homework2_mybatis.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    @Operation(summary = "Get all courses")
    public ResponseEntity<ApiResponse<Course>> getAllCourses(
            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "10") @Max(10) Integer size
    ){
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(200)
                .message("Courses fetched successfully")
                .payload(courseService.getAllCourses(page, size))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{course-id}")
    @Operation(summary = "Get course by ID")
    public ResponseEntity<ApiResponse<Course>> getCourseById(
            @PathVariable("course-id") Integer courseId
    ){
        if(courseService.getCourseById(courseId) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Course fetched successfully")
                    .payload(courseService.getCourseById(courseId))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .status(404)
                .message("No courses found with the given ID")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    @Operation(summary = "Create a new course")
    public ResponseEntity<ApiResponse<Course>> createNewCourse(@RequestBody CourseRequest courseRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(201)
                .message("Course created successfully")
                .payload(courseService.createNewCourse(courseRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{course-id}")
    @Operation(summary = "Update course by ID")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(
            @PathVariable("course-id") Integer courseId,
            @RequestBody CourseRequest courseRequest
    ){
        if(courseService.updateCourseById(courseId,courseRequest) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Course updated successfully")
                    .payload(courseService.updateCourseById(courseId,courseRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .status(404)
                .message("No courses found with the given ID")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @DeleteMapping("/{course-id}")
    @Operation(summary = "Delete course by ID")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(
            @PathVariable("course-id") Integer courseId
    ){
        if(courseService.deleteCourseById(courseId) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Course deleted successfully")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .status(404)
                .message("No courses found with the given ID")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
