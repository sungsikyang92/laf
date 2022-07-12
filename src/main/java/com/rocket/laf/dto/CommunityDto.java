package com.rocket.laf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private long cBoardNo;
    private String cTitle;
    private String cContent;
    private Date cCreateDate;
    private boolean cIsModified;
    private String cLocation;
    private String cCategory;
    private long userNo;
    private long hashNo;
    private long picNo;
}
