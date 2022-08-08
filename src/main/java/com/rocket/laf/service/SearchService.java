package com.rocket.laf.service;

import com.rocket.laf.dto.MainListDto;

import java.util.List;

public interface SearchService {
    List<MainListDto> getSearchResult(String searchArg);
}
