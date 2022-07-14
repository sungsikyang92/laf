package com.rocket.laf.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LostDto {
    private long lBoardNo;
    private String lTitle;
    private String lContent;
    private Date lCreateDate;
    private String lIsModified;
    private String lLocation;
    private String lCategory;
    private String lQuestion;
    private String lAnswers;
    private long userNo;
    private long hashNo;
    private long picNo;
    private String mainPicLoc;
}
