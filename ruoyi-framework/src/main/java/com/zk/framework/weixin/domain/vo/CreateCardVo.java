package com.zk.framework.weixin.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Classname CraeteCardVo
 * @Description TODO 创建卡券前端传入视图对象
 * @Date 2020/8/17 10:10 AM
 * @Created by nihui
 * @Version 1.0
 * @Description CraeteCardVo @see ruoyi
 */
public class CreateCardVo {

    /**
     * 初始容量
     */
    private Integer quantity;

    /**
     * 使用时间类型
     */

    private String dateType;


    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:SS")
    private String sday;
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:SS")
    private String stime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:SS")
    private String eday;
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:SS")
    private String etime;

    /**
     * logo 地址
     */
    private String logo_url;

    /**
     * 卡券标题
     */

    private String title;

    /**
     * 商户名称
     */
    private String brandName;

    /**
     * 颜色
     */
    private String color;

    /**
     * 卡券使用提醒
     */
    private String notice;

    /**
     * 卡券使用说明
     */
    private String description;

    /**
     * 卡券描述
     */
    private String card_details;

    /**
     * 卡券类型
     */
    private String cardType;

    public CreateCardVo(Integer quantity, String dateType, String sday, String stime, String eday, String etime, String logo_url, String title, String brandName, String color, String notice, String description, String card_details, String cardType) {
        this.quantity = quantity;
        this.dateType = dateType;
        this.sday = sday;
        this.stime = stime;
        this.eday = eday;
        this.etime = etime;
        this.logo_url = logo_url;
        this.title = title;
        this.brandName = brandName;
        this.color = color;
        this.notice = notice;
        this.description = description;
        this.card_details = card_details;
        this.cardType = cardType;
    }

    public CreateCardVo() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getSday() {
        return sday;
    }

    public void setSday(String sday) {
        this.sday = sday;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEday() {
        return eday;
    }

    public void setEday(String eday) {
        this.eday = eday;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCard_details() {
        return card_details;
    }

    public void setCard_details(String card_details) {
        this.card_details = card_details;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}