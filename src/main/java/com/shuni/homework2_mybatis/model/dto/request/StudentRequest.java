package com.shuni.homework2_mybatis.model.dto.request;

import com.shuni.homework2_mybatis.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private Integer courseId;

}
