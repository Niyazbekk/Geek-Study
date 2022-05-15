package com.example.coursescoreapi.Repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "user_id cannot be null")
    private int userID;
    @NotNull(message = "course_name cannot be null")
    private String course_name;
    private String course_description;

}
