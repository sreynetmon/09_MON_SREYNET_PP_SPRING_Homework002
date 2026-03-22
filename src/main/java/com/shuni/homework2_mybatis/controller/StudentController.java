package com.shuni.homework2_mybatis.controller;

import com.shuni.homework2_mybatis.model.dto.request.StudentRequest;
import com.shuni.homework2_mybatis.model.dto.response.ApiResponse;
import com.shuni.homework2_mybatis.model.entity.Student;
import com.shuni.homework2_mybatis.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    @Operation(summary = "Get all students")
    public ResponseEntity<ApiResponse<Student>> getAllStudents(
            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "10") @Max(10) Integer size
    ){
//        List<Student> students = studentService.getAllStudents(page,size);
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(200)
                .message("Students retrieved successfully")
                .payload(studentService.getAllStudents(page, size))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{student-id}")
    @Operation(summary = "Get student by ID")
    public ResponseEntity<ApiResponse<Student>> getStudentById(
            @PathVariable ("student-id") Integer studentId
    ){
        if(studentService.getStudentById(studentId) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Student fetched successfully")
                    .payload(studentService.getStudentById(studentId))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .status(404)
                .message("No students found with the given ID")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    @Operation(summary = "Create a student")
    public ResponseEntity<ApiResponse<Student>> CreateStudent(
            @RequestBody StudentRequest studentRequest
            ){
        return null;
    }
//    {
//        ApiResponse response = ApiResponse.builder()
//                .success(true)
//                .status(201)
//                .message("Instructor created successfully")
//                .payload(studentService.createStudent(studentRequest))
//                .timestamp(Instant.now())
//                .build();
//        return ResponseEntity.ok(response);
//
//    }

    @PutMapping("/{student-id}")
    @Operation(summary = "Update Student By ID")
    public ResponseEntity<ApiResponse<Student>> updateStudentById(
            @PathVariable("student-id") Integer studentId,
            @RequestBody StudentRequest studentRequest
    ){
        if(studentService.updateStudentById(studentId,studentRequest) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Student updated successfully")
                    .payload(studentService.updateStudentById(studentId,studentRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .status(404)
                .message("No instructors found with the given ID")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }


    @DeleteMapping("/{student-id}")
    @Operation(summary = "Delete student by ID")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(
            @PathVariable("student-id") Integer studentId
    ){
        if(studentService.deleteStudentById(studentId)  != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Student deleted successfully")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(response);
        }
        ApiResponse response = ApiResponse.builder()
                .success(false)
                .status(404)
                .message("No instructors found with the given ID")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
