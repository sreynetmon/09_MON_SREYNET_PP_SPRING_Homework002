package com.shuni.homework2_mybatis.model.dto.request;

import com.shuni.homework2_mybatis.model.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Integer instructorId;
}
