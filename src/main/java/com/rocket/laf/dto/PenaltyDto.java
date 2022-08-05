package com.rocket.laf.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PenaltyDto {
    public String pUserId;
    public String pBoardNo;
    public int penaltyCnt;
}
