package com.example.lecturecoreapi.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_attach")
@Data
@NoArgsConstructor
public class Attachment {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private Long courseID;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    public Attachment(String fileName, Long courseID, String fileType, byte[] data) {
        this.fileName = fileName;
        this.courseID = courseID;
        this.fileType = fileType;
        this.data = data;
    }
}