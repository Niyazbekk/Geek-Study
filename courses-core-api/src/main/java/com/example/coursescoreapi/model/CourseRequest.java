package com.example.coursescoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequest {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "user_id cannot be null")
    private int userID;
    @NotNull(message = "course_name cannot be null")
    private String course_name;
    private String course_description;
}
