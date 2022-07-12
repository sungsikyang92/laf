package com.rocket.laf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private long cBoardNo;
    private String cTitle;
    private String cContent;
    private Date cCreateDate;
    private boolean cIsModified;
    private String cLocation;
    private String cCategory;
    private long userNo;
    private long hashNo;
    private long picNo;

    /*
     * public CommunityDto() {
     * super();
     * // TODO Auto-generated constructor stub
     * }
     * 
     * public CommunityDto(Long cBoardNo, String cTitle, String cContent, Date
     * cCreateDate, boolean cIsModified,
     * String cLocation, String cCategory, Long userNo, Long hashNo, Long picNo) {
     * super();
     * this.cBoardNo = cBoardNo;
     * this.cTitle = cTitle;
     * this.cContent = cContent;
     * this.cCreateDate = cCreateDate;
     * this.cIsModified = cIsModified;
     * this.cLocation = cLocation;
     * this.cCategory = cCategory;
     * this.userNo = userNo;
     * this.hashNo = hashNo;
     * this.picNo = picNo;
     * }
     * 
     * public Long getCBoardNo() {
     * return this.cBoardNo;
     * }
     * 
     * public void setCBoardNo(Long cBoardNo) {
     * this.cBoardNo = cBoardNo;
     * }
     * 
     * public String getCTitle() {
     * return this.cTitle;
     * }
     * 
     * public void setCTitle(String cTitle) {
     * this.cTitle = cTitle;
     * }
     * 
     * public String getCContent() {
     * return this.cContent;
     * }
     * 
     * public void setCContent(String cContent) {
     * this.cContent = cContent;
     * }
     * 
     * public Date getCCreateDate() {
     * return this.cCreateDate;
     * }
     * 
     * public void setCCreateDate(Date cCreateDate) {
     * this.cCreateDate = cCreateDate;
     * }
     * 
     * public boolean isCIsModified() {
     * return this.cIsModified;
     * }
     * 
     * public void setCIsModified(boolean cIsModified) {
     * this.cIsModified = cIsModified;
     * }
     * 
     * public String getCLocation() {
     * return this.cLocation;
     * }
     * 
     * public void setCLocation(String cLocation) {
     * this.cLocation = cLocation;
     * }
     * 
     * public String getCCategory() {
     * return this.cCategory;
     * }
     * 
     * public void setCCategory(String cCategory) {
     * this.cCategory = cCategory;
     * }
     * 
     * public Long getUserNo() {
     * return this.userNo;
     * }
     * 
     * public void setUserNo(Long userNo) {
     * this.userNo = userNo;
     * }
     * 
     * public Long getHashNo() {
     * return this.hashNo;
     * }
     * 
     * public void setHashNo(Long hashNo) {
     * this.hashNo = hashNo;
     * }
     * 
     * public Long getPicNo() {
     * return this.picNo;
     * }
     * 
     * public void setPicNo(Long picNo) {
     * this.picNo = picNo;
     * }
     */
}
