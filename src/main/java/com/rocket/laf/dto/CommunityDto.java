package com.rocket.laf.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private String boardNo;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private boolean modified;
    private String location;
    private String category;
    private long userNo;
    private long hashNo;
}