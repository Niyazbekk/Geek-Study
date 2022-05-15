package com.example.studyofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollResponse {
    private Long Id;
    @NotNull(message = "userId cannot be empty")
    private Long userID;

    @NotNull(message = "courseId cannot be empty")
    private Long courseID;
}
