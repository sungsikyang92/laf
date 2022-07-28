package com.rocket.laf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.rocket.laf.dto.ReviewDto;

@Mapper
public interface ReviewMapper {

    @Insert( "insert into Review (rUserId, rRevieweeId, rContent, rOption, rScore) VALUES ( #{rUserId}, #{rRevieweeId}, #{rContent}, #{rOption}, #{rScore})")
    int saveReview(ReviewDto dto);

}
