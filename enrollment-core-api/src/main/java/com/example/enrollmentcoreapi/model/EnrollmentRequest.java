package com.example.enrollmentcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentRequest {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "user_id cannot be null")
    private Long userID;
    @NotNull(message = "course_ID cannot be null")
    private Long courseID;
}
