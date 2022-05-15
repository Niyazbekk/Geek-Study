package com.example.studyofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseResponse {
    @NotNull(message = "courseId cannot be null")
    private Long id;
    @NotNull(message = "user_id cannot be null")
    private int userID;
    @NotNull(message = "course_name cannot be null")
    private String course_name;
    private String course_description;
}
