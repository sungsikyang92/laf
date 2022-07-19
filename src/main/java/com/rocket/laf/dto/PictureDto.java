package com.rocket.laf.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PictureDto {
    private long picNo;
    private String boardNo;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
    private boolean isDeleted;
}
