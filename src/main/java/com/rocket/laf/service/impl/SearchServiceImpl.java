package com.rocket.laf.service.impl;

import com.rocket.laf.dto.MainListDto;
import com.rocket.laf.mapper.SearchMapper;
import com.rocket.laf.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchMapper searchMapper;

    @Override
    public List<MainListDto> getSearchResult(String searchArg) {
        return searchMapper.getSearchResult(searchArg);
    }
}
