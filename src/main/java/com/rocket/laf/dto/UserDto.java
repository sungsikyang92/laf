package com.rocket.laf.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    
    private long userNo;
    private String userName;
    private String userId;
    private String userEmail;
    private String userPw;
    private String userPhone;
    private int userTicket;
    private String userGrade;
    private String socialProvider;

}