package com.rocket.laf.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private long cBoardNo;
    private String cTitle;
    private String cContent;
    private LocalDateTime cCreateDate;
    private boolean cIsModified;
    private String cLocation;
    private String cCategory;
    private long userNo;
    private long hashNo;
    private long picNo;
}
