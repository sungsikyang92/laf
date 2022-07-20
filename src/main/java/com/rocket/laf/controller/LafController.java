package com.rocket.laf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.service.impl.LostServiceImpl;
import com.rocket.laf.service.impl.PictureServiceImpl;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LafController {

    @Autowired
    private LostServiceImpl lostserviceImpl;
    @Autowired
    private PictureServiceImpl pictureServiceImpl;

    @GetMapping("/")
    public String main(Model model) {
        List<LostDto> lostlist = lostserviceImpl.getLostBoardList();
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
        List<LostDto> lolist = lostserviceImpl.getLostBoardOne(boardNo);
        List<PictureDto> piclist = pictureServiceImpl.getAllPictuer(picNo);

        model.addAttribute("allpicture", piclist);
        model.addAttribute("boardDetail", lolist);

        return "lostcommunity/lostdetail";
    }

    @PostMapping("/post_Quiz")
    public String LostCreate() {
        return "index";
    }
}
