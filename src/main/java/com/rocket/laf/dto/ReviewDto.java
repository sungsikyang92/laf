package com.rocket.laf.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDto {
    private int reviewNo;
    private String rContent;
    private int rScore;
    private UserDto userDto;

}
