package com.rocket.laf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.service.LostService;
import com.rocket.laf.service.PictureService;

@Controller
@RequestMapping("/")
public class LafController {

    @Autowired
    private LostService lostservice;
    @Autowired
    private PictureService pictureService;

    @GetMapping("/")
    public String main(Model model) {
        List<LostDto> lostlist = lostservice.getLostBoardList();

        model.addAttribute("lostlist", lostlist);
        return "index";
    }

    @GetMapping("/Lostwrite")
    public String Lostwrite() {
        return "lostcommunity/lostwrite";
    }

    @GetMapping("/lostdetail")
    public String LostDetail(HttpServletRequest req, Model model) {
        String boardNo = req.getParameter("lBNo");
        String picNo = req.getParameter("PicNo");
        List<LostDto> lolist = lostservice.getLostBoardOne(boardNo);
        List<PictureDto> piclist = pictureService.getAllPictuer(picNo);

        model.addAttribute("allpicture", piclist);
        model.addAttribute("boardDetail", lolist);

        return "lostcommunity/lostdetail";
    }

    @PostMapping("post")
    public String LostCreate() {
        return "index";
    }
}
