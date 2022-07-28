package com.rocket.laf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.ReviewDto;
import com.rocket.laf.mapper.ReviewMapper;
import com.rocket.laf.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public int saveReview(ReviewDto dto) {
        return reviewMapper.saveReview(dto);
    }
    
}
