package com.rocket.laf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private Long cBoardNo;
    private String cTitle;
    private String cContent;
    private Date cCreateDate;
    private boolean cIsModified;
    private String cLocation;
    private String cCategory;
    private Long userNo;
    private Long hashNo;
    private Long picNo;
}
