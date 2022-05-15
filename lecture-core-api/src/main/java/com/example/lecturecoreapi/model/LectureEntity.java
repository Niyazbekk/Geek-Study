package com.example.lecturecoreapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_lecture")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class LectureEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "course Id cannot be null")
    private Long courseID;

    private String lecture_message;

}
