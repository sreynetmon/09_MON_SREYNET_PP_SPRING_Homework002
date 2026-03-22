package com.shuni.homework2_mybatis.controller;
import com.shuni.homework2_mybatis.model.dto.request.InstructorRequest;
import com.shuni.homework2_mybatis.model.dto.response.ApiResponse;
import com.shuni.homework2_mybatis.model.entity.Instructor;
import com.shuni.homework2_mybatis.service.InstructorService;
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
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping
    @Operation(summary = "Get all instructors")
    public ResponseEntity<ApiResponse<Instructor>> getAllInstructors(
            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "10") @Max(10) Integer size
    ){
        List<Instructor> instructors = instructorService.getAllInstructors(page, size);
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .status(200)
                .message("Instructors fetched successfully")
                .payload(instructorService.getAllInstructors(page,size))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{instructor-id}")
    @Operation(summary = "Get instructor by ID")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(
            @PathVariable("instructor-id") Integer instructorId
    ){
        if(instructorService.getInstructorById(instructorId)  != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Instructor fetched successfully")
                    .payload(instructorService.getInstructorById(instructorId))
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

    @PostMapping
    @Operation(summary = "Create a new instructor")
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody InstructorRequest instructorRequest){
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .status(201)
                .message("Instructor created successfully")
                .payload(instructorService.createInstructor(instructorRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{instructor-id}")
    @Operation(summary = "Update instructor by ID")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(
            @PathVariable("instructor-id") Integer instructorId,
            @RequestBody InstructorRequest instructorRequest
    ){
        if(instructorService.updateInstructorById(instructorId, instructorRequest) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Instructor updated successfully")
                    .payload(instructorService.updateInstructorById(instructorId, instructorRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
        ApiResponse response = ApiResponse.builder()
                .success(false)
                .status(404)
                .message("No instructors found with the given ID")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{instructor-id}")
    @Operation(summary = "Delete instructor by ID")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(
            @PathVariable("instructor-id") Integer instructorId
    ){
        if(instructorService.deleteInstructorById(instructorId)  != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(200)
                    .message("Instructor deleted successfully")
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
