package com.rocket.laf.dto;

<<<<<<< HEAD
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
=======
import lombok.*;

import java.time.LocalDateTime;

@Data
>>>>>>> 0346a107d07d6b2a795aada837d5676f666eb4d9
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private String cBoardNo;
    private String cTitle;
    private String cContent;
    private LocalDateTime cCreateDate;
    private boolean cIsModified;
    private String cLocation;
    private String cCategory;
    private long userNo;
    private long hashNo;
    private long picNo;

    
    
}
