package com.rocket.laf.controller;

import java.net.MalformedURLException;

import com.rocket.laf.mapper.BoardNoMapper;
import com.rocket.laf.service.BoardNoService;
import com.rocket.laf.service.impl.BoardNoServiceImpl;
import com.rocket.laf.service.impl.PictureServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rocket.laf.service.PictureService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/picture")
public class PictureController {

    private final PictureServiceImpl pictureService;
    private final BoardNoServiceImpl boardNoService;

    @GetMapping("")
    public String addPicture() {

        return "";
    }

    /*
     * @GetMapping("/images/{filename}")
     * public Resource showImage(@PathVariable String filename) throws
     * MalformedURLException {
     * 
     * return new UrlResource("file" + file.getFullPath(filename));
     * }
     */

    public String getPicture() {
        return "";
    }

    public String getMainPicture() {
        return "";
    }

    @GetMapping("/delete/{picNo}")
    public String deletePicture(@PathVariable (name = "picNo") Long picNo) {
        String boardNo = boardNoService.getBoardNoByPicNo(picNo);
        pictureService.deleteSelectedPic(picNo);
        return "redirect:/cBoard/" + boardNo;
    }
}
