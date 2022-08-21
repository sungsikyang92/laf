package com.rocket.laf.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LostDto {
    private String boardNo;
    private String title;
    private String content;
    private Date createDate;
    private String modified;
    private String location;
    private String category;
    private String question;
    private String answers;
    private String answers1;
    private String answers2;
    private String answers3;
    private String answers4;
    private long userNo;
    private long hashNo;
}