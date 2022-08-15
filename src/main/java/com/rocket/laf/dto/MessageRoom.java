package com.rocket.laf.dto;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Data
public class MessageRoom {
    private long roomId;
    //분실물을 찾아주는 사람
    private String boardNo;
    //분실물을 찾고싶은 사람
    private Long userNo;
}
