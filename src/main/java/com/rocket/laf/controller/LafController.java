package com.rocket.laf.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rocket.laf.dto.MessageRoom;
import com.rocket.laf.dto.UserDto;
import com.rocket.laf.service.impl.*;
import lombok.RequiredArgsConstructor;

import org.apache.catalina.User;
import org.apache.catalina.util.URLEncoder;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LafController {

    private final LostServiceImpl lostserviceImpl;
    private final PictureServiceImpl pictureServiceImpl;
    private final BoardNoServiceImpl boardNoServiceImpl;
    private final UserServiceImpl userService;
    private final ChatServiceImpl chatServiceImpl;

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
        System.out.println("이게 왜 실행이 될까요?");
        
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

//    @GetMapping("/post_Quiz")
//    public String LostChatCreate(HttpServletRequest req, @RequestParam String loginUserName, @RequestParam String boardNo) {
//
//        String answer = req.getParameter("ans");
//        LostDto lost = lostserviceImpl.getLostBoardOne(boardNo);
//        MessageRoom messageRoom = new MessageRoom();
//        if (lost.getAnswers().equals(answer)) {
//            UserDto userInfo = userService.getUserInfoById(loginUserName);
//            long userNo = userService.getUserNoById(loginUserName);
//            LostDto boardInfo = lostserviceImpl.getLostBoardOne(boardNo);
//            long roomId = chatServiceImpl.getRoomIdByuserNo(userNo, boardNo);
//            if (chatServiceImpl.chkChatRoomExist(boardNo, userNo) == 0) {
//                chatServiceImpl.createChatRoom(boardNo, userNo);
//                messageRoom.setRoomId(roomId);
//                messageRoom.setUserNo(userNo);
//                messageRoom.setBoardNo(boardNo);
//                messageRoom.setBoardInfo(boardInfo);
//                messageRoom.setUserInfo(userInfo);
//                return "redirect:/localhost:3000/room/enter/"+ roomId;
//            } else {
//                messageRoom.setRoomId(roomId);
//                messageRoom.setUserNo(userNo);
//                messageRoom.setBoardNo(boardNo);
//                messageRoom.setBoardInfo(boardInfo);
//                messageRoom.setUserInfo(userInfo);
//                return "redirect:/localhost:3000/room/enter/"+ roomId;
//            }
//        }
//        return "redirect:/";
//    }
    @GetMapping("/post_Quiz")
    public ModelAndView LostChatCreate(HttpServletRequest req, @RequestParam String loginUserName, @RequestParam String boardNo) {
        ModelAndView mv = new ModelAndView();
        String answer = req.getParameter("ans");
        LostDto lost = lostserviceImpl.getLostBoardOne(boardNo);
        MessageRoom messageRoom = new MessageRoom();
        if (lost.getAnswers().equals(answer)) {
            UserDto userInfo = userService.getUserInfoById(loginUserName);
            long userNo = userService.getUserNoById(loginUserName);
            LostDto boardInfo = lostserviceImpl.getLostBoardOne(boardNo);
            long roomId = chatServiceImpl.getRoomIdByuserNo(userNo, boardNo);
            messageRoom.setRoomId(roomId);
            messageRoom.setUserNo(userNo);
            messageRoom.setBoardNo(boardNo);
            if (chatServiceImpl.chkChatRoomExist(boardNo, userNo) == 0) {
                chatServiceImpl.createChatRoom(boardNo, userNo);
            }
            String url = "redirect://localhost:3000/?roomId="+roomId+"&&userName="+userInfo.getUserName();
            mv.setViewName(url);
        }
        return mv;
    }


    @GetMapping("/update/{boardNo}")
    public String updatelBoardNo(@PathVariable(name = "boardNo") String boardNo, Model model) {

        LostDto lostDto = lostserviceImpl.getLostBoardOne(boardNo);
        List<PictureDto> picList = pictureServiceImpl.getAllPictureByBoardNo(boardNo);
//        for (PictureDto pdto : picList) {
//            String originPath = pdto.getStoredFilePath();
//            pdto.setStoredFilePath("/resources/" + originPath.substring(26));
//        }

        for (PictureDto pdto : picList) {
            String originPath = pdto.getStoredFilePath();
            if (originPath != null)
                pdto.setStoredFilePath("/resources/img/communityBoard/" + originPath.substring(45));
            else
                continue;
        }
        model.addAttribute("lboard", lostDto);
        model.addAttribute("pDetail", picList);

        return "lost/lostUpdate";
    }

    @PostMapping("/update/{boardNo}")
    public String updatelBoard(@PathVariable(name = "boardNo") String boardNo, LostDto lostDto,
            MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        lostserviceImpl.updatelBoardDetail(lostDto, multipartHttpServletRequest);
        return "redirect:/"+boardNo;
    }


}