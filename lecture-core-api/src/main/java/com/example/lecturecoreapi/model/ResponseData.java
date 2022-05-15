package com.example.lecturecoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private String fileName;
    private Long courseID;
    private String downloadURL;
    private String fileType;
    private long fileSize;
}
