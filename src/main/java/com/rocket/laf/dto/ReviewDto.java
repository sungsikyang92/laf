package com.rocket.laf.dto;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
public class ReviewDto extends UserDto {

    private int reviewNo;
    private Date rDate;
    private String rUserId;
    private String rRevieweeId;
    private String rContent;
    private String rOption;
    private int rScore;

 }