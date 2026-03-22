package com.shuni.homework2_mybatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private Instructor instructor;
}
