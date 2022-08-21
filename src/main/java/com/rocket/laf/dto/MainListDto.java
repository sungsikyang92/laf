package com.rocket.laf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainListDto {
    private String boardNo;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private boolean modified;
    private String location;
    private String category;
    private long userNo;
    private long hashNo;
//    private List<PictureDto> pictureList;
    private long picNo;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
    private boolean picRmd;
    private boolean picExt;
}