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
import com.rocket.laf.service.impl.BoardNoServiceImpl;
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
    @Autowired
    private final BoardNoServiceImpl boardNoService;

    @GetMapping("/")
    public String main(Model model) {
        List<LostDto> lostlist = lostserviceImpl.getLostBoardList();

        for (int i = 0; i < lostlist.size(); i++) {
            String originPath = lostlist.get(i).getStoredFilePath();
            lostlist.get(i).setStoredFilePath("/resources/" + originPath.substring(26));
        }
        model.addAttribute("lostlist", lostlist);
        // List<PictureDto> piclist =
        // pictureServiceImpl.getMainPictureByBoardNo(lostlist.get(0).getLBoardNo());
        // model.addAttribute("picture", piclist);
        return "index";
    }

    // 성식님한테 {boardNo} 물어볼것.
    @GetMapping("/lostDetail")
    public String LostDetail(HttpServletRequest req, Model model) {
        String boardNo = req.getParameter("lBNo");
        List<LostDto> lolist = lostserviceImpl.getLostBoardOne(boardNo);
        List<PictureDto> piclist = pictureServiceImpl.getAllPictureByBoardNo(boardNo);

        for (int i = 0; i < piclist.size(); i++) {
            String originPath = piclist.get(i).getStoredFilePath();
            piclist.get(i).setStoredFilePath("/resources/" + originPath.substring(26));

        }

        model.addAttribute("picturelist", piclist);
        model.addAttribute("boardDetail", lolist);

        return "lostcommunity/lostDetail";
    }

    @GetMapping("/lostWrite")
    public String lostWrite() {
        return "lostcommunity/lostWrite";
    }

    @PostMapping("/lostwrite")
    public String lostWriteform() {
        String symbol = "l";
        long bnumbering = boardNoService.getMaxBoardNo() + 1;

        return "redirect:/";
    }

    @PostMapping("/post_Quiz")
    public String LostCreate() {
        return "index";
    }
}