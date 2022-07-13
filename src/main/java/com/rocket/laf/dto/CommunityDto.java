package com.rocket.laf.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommunityDto {
    private int cBoardNo;
    private String cTitle;
    private String cContent;
    private Date cCreateDate;
    private boolean cIsModified;
    private String cLocation;
    private String cCategory;
    private int userNo;
    private int hashNo;
    private int picNo;
}
