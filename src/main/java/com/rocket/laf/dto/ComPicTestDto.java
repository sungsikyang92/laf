package com.rocket.laf.dto;

import lombok.Data;

@Data
public class ComPicTestDto {
    private long idx;
    private long cBoardNo;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
}
