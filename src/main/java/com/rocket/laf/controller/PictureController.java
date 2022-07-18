package com.rocket.laf.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rocket.laf.service.PictureService;

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

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

    public String deletePicture() {
        return "";
    }
}
