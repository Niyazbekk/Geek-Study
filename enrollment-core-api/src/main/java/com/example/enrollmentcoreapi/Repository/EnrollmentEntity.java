package com.example.enrollmentcoreapi.Repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_enroll")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class EnrollmentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "user_id cannot be null")
    private Long userID;
    @NotNull(message = "course_ID cannot be null")
    private Long courseID;
}
