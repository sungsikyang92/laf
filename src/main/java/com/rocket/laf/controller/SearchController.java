package com.rocket.laf.controller;

import com.rocket.laf.dto.MainListDto;
import com.rocket.laf.service.impl.SearchServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchServiceImpl searchService;

    @GetMapping("/{searchArg}")
    public List<MainListDto> getSearchResult(@PathVariable String searchArg) {
        List<MainListDto> searchListDtos = searchService.getSearchResult(searchArg);
        for (MainListDto mainListDto : searchListDtos) {
            if (mainListDto.isPicExt() == true) {
                String picOriginPath = mainListDto.getStoredFilePath();
                mainListDto.setStoredFilePath("/resources/img/lostBoard/" + picOriginPath.substring(40));
            } else {
                continue;
            }
        }
        return searchListDtos;
    }
}
