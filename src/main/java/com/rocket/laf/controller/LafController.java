package com.rocket.laf.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rocket.laf.dto.UserDto;
import com.rocket.laf.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;

import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.service.impl.BoardNoServiceImpl;
import com.rocket.laf.service.impl.LostServiceImpl;
import com.rocket.laf.service.impl.PictureServiceImpl;

import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LafController {

    private final LostServiceImpl lostserviceImpl;
    private final PictureServiceImpl pictureServiceImpl;
    private final BoardNoServiceImpl boardNoServiceImpl;
    private final UserServiceImpl userService;

    private final static Logger logger = Logger.getGlobal();

    //팀장님, 로그인 유저정보 로그 확인을 위해서 Authentication 추가 했습니다.
    @GetMapping("")
    public String main(Model model, @AuthenticationPrincipal User userInfo, Authentication auth, HttpServletRequest request) {
        
        logger.info("index.jsp 실행");
        
        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
        if (trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
            System.out.println("익명의 사용자 _________ " + userInfo);
            System.out.println("익명의 사용자 인증정보_________ " + auth);
        } else {
            System.out.println("로그인한 사용자_________ " + userInfo);
            //System.out.println("로그인한 사용자 아이디_________ " +  userInfo.getUsername());
            //System.out.println("로그인한 사용자 번호_________ " +  userInfo.getUserNo());
            System.out.println("로그인한 사용자 인증정보_________ " + auth);
        }

        Object list = request.getSession().getAttribute("penaltyObj");
        System.out.println("컨트롤러 세션유지호가인 ____ " + list);

        List<LostDto> lostlist = lostserviceImpl.getLostBoardList();
        List<PictureDto> PictureDtoList = pictureServiceImpl.getMainPictureForLost();
        for (PictureDto pDto : PictureDtoList) {
            if (pDto.isPicExt() == true) {
                String picOriginPath = pDto.getStoredFilePath();
                pDto.setStoredFilePath("/resources/img/lostBoard/" + picOriginPath.substring(40));
            } else {
                continue;
            }
        }

        model.addAttribute("lostlist", lostlist);
        model.addAttribute("picList", PictureDtoList);
        return "index";
    }

//    @GetMapping("/lost")
//    public List<>

    @GetMapping("/write")
    public String lostWrite() {
        return "lost/lostWrite";
    }

    @PostMapping("/write")
    public String lostWriteform(LostDto lostDto, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
//        String symbol = "l";
//        long bnumbering = boardNoServiceImpl.getMaxlBoardNo() + 1;
//        boardNoServiceImpl.addlBoardNo(bnumbering);
//
//        String numbering = String.format("%08d", bnumbering);
//        logger.log(Level.INFO, numbering);
//        String lBoardNo = symbol + numbering;
//        logger.log(Level.INFO, lBoardNo);
//
//        lostserviceImpl.insertLostBoard(lostDto, multipartHttpServletRequest);
//        return "redirect:/";
        String symbol = "l";
        long bnumbering = boardNoServiceImpl.getMaxlBoardNo() + 1;
        boardNoServiceImpl.addlBoardNo(bnumbering);

        String numbering = String.format("%08d", bnumbering);
        String lBoardNo = symbol + numbering;
        lostDto.setBoardNo(lBoardNo);
        lostserviceImpl.insertLostBoard(lostDto, multipartHttpServletRequest);
        return "redirect:/";
    }

    @GetMapping("/{boardNo}")
    public String LostDetail(@PathVariable(name = "boardNo") String boardNo, Model model) {
        LostDto lostDto = lostserviceImpl.getLostBoardOne(boardNo);
        long writerNo = lostDto.getUserNo();
        UserDto writerInfo = userService.getUserById(writerNo);
        List<PictureDto> pictureDtoList = new ArrayList<>();
        List<PictureDto> piclist = pictureServiceImpl.getAllPictureByBoardNo(boardNo);
        for (PictureDto pDto : piclist) {
            if (pDto.isPicExt() == true) {
                String originPath = pDto.getStoredFilePath();
                pDto.setStoredFilePath("/resources/img/lostBoard/" + originPath.substring(40));
                pictureDtoList.add(pDto);
            } else {
                pictureDtoList.add(pDto);
            }
        }
        model.addAttribute("picturelist", piclist);
        model.addAttribute("boardDetail", lostDto);
        model.addAttribute("writerInfo", writerInfo);
        return "lost/lostDetail";
    }

    @PostMapping("/post_Quiz")
    public String LostChatCreate(HttpServletRequest req, Model model, @RequestParam String loginUserName, Principal principal) {

        String answer = req.getParameter("ans");
        String bNo = req.getParameter("boardNo");
        String userA = req.getParameter("writerName");
        String userB = loginUserName;


//        logger.log(Level.INFO, answer);
//        logger.log(Level.INFO, bNo);
        LostDto lost = lostserviceImpl.getLostBoardOne(bNo);
        if (lost.getAnswers().equals(answer)) {
//            String roomId = createdRoom.getRoomId();
//            chatRoomRepository.enterChatRoom(createdRoom.getRoomId());
            return "chat/chatDetail";
//            return "redirect:/chat/room/enter/"+roomId;
        } else {
            return "redirect:/lostDetail";
        }
    }

    @GetMapping("/update/{lBoardNo}")
    public String updatelBoardNo(@PathVariable(name = "lBoardNo") String lBoardNo, Model model) {

        LostDto lostDto = lostserviceImpl.getLostBoardOne(lBoardNo);
        List<PictureDto> picList = pictureServiceImpl.getAllPictureByBoardNo(lBoardNo);
        for (PictureDto pdto : picList) {
            String originPath = pdto.getStoredFilePath();
            pdto.setStoredFilePath("/resources/" + originPath.substring(26));
        }

        model.addAttribute("lboard", lostDto);
        model.addAttribute("pDetail", picList);

        return "lost/lostUpdate";
    }

    @PostMapping("/update/{lBoardNo}")
    public String updatelBoard(@PathVariable(name = "lBoardNo") String lBoardNo, LostDto lostDto,
            MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        lostserviceImpl.updatelBoardDetail(lostDto, multipartHttpServletRequest);
        return "redirect:/"+lBoardNo;
    }


}