package com.rocket.laf.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rocket.laf.common.FileUtils;
import com.rocket.laf.common.ObjDetectionApi;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.service.impl.BoardNoServiceImpl;
import com.rocket.laf.service.impl.PictureServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.servlet.http.HttpServletRequest;
//objdect001 --
@Slf4j
//--
@RequiredArgsConstructor
@Controller
@RequestMapping("/picture")
public class PictureController {

    private final PictureServiceImpl pictureService;
    private final BoardNoServiceImpl boardNoService;
    //lostdect001--
    private final FileUtils fileUtils;
    //--


    @ResponseBody
    @GetMapping("")
    public List<PictureDto> getMainPictureByBoardNo(HttpServletRequest request) {
        String boardNo = request.getParameter("boardNo");
        List<PictureDto> pictureDtoList = new ArrayList<>();
        if (boardNo.equals("l")) {
            List<PictureDto> mainPicList = pictureService.getMainPictureForLost();
            for (PictureDto pDto : mainPicList) {
                if (pDto.isPicExt() == true) {
                    String picOriginPath = pDto.getStoredFilePath();
                    pDto.setStoredFilePath("/resources/img/lostBoard/" + picOriginPath.substring(40));
                    pictureDtoList.add(pDto);
                } else {
                    pictureDtoList.add(pDto);
                }
            }
            return pictureDtoList;
        } else {
            List<PictureDto> mainPicList = pictureService.getMainPictureForCom();
            for (PictureDto pDto : mainPicList) {
                if (pDto.isPicExt() == true) {
                    String picOriginPath = pDto.getStoredFilePath();
                    pDto.setStoredFilePath("/resources/img/communityBoard/" + picOriginPath.substring(45));
                    pictureDtoList.add(pDto);
                } else {
                    pictureDtoList.add(pDto);
                }
            }
            return pictureDtoList;
        }
    }

    @ResponseBody
    @GetMapping("/delete/{picNo}")
    public List<PictureDto> deletePicture(@PathVariable(name = "picNo") Long picNo) {//사진 삭제 후 리스트 반환
        String boardNo = boardNoService.getBoardNoByPicNo(picNo);
        pictureService.deleteSelectedPic(picNo);
        List<PictureDto> pictureList = pictureService.getAllPictureByBoardNo(boardNo);
        for (PictureDto pdto : pictureList) {
            String originPath = pdto.getStoredFilePath();
            pdto.setStoredFilePath("/resources/img/communityBoard/" + originPath.substring(45));
        }
        return pictureList;

    }

    //objdect001 --
    @PostMapping("/objDect")
    @ResponseBody
    public Object callObjDect (MultipartHttpServletRequest multiReq) throws IOException, InterruptedException{
        log.info("callObjDect 실행");
        MultipartFile pixObj = multiReq.getFile("tempPix");
        List<File> tempFileInfo = fileUtils.createTempFile(pixObj);
        String tempFile = tempFileInfo.get(1).toString();

        //파일 압축 하는것도 생각해볼 필요있음 2메가 제한이라.
        Object objRtn =  new ObjDetectionApi().callObjApi(tempFile);
        System.out.println();
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = ");
        System.out.println();
        System.out.println("ObjApiReturn: " + objRtn);
        System.out.println();
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = ");
        System.out.println();

        fileUtils.deleteTempFile(tempFileInfo.get(1));

        return objRtn;
    }
    //--

}