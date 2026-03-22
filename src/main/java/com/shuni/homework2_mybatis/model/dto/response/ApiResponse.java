package com.shuni.homework2_mybatis.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse <T> {
    private boolean success;
    private int status;
    private String message;
    private T payload;
    private Instant timestamp;
}
