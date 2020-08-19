package com.zk.system.domain.weixin.domain.vo;

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

    /*************页面展示部分***********/
    /**
     * logo 地址
     */
    private String logo_url;
    /**
     * 商户名称
     */
    private String brandName;

    /**
     * 卡券标题
     */
    private String title;

    /**
     * 预留字段点击立即使用进行跳转
     */
    //private String center_url;

    private String sub_title;

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


    /*************逻辑说明部分**********/

    /**
     * 卡券类型
     */
    private String cardType;
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

    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 是否转赠
     */
    private boolean can_give_friend;


    public CreateCardVo(String logo_url, String brandName, String title, String sub_title, String color, String notice, String description, String card_details, String cardType, Integer quantity, String dateType, Date startTime, Date endTime, boolean can_give_friend) {
        this.logo_url = logo_url;
        this.brandName = brandName;
        this.title = title;
        this.sub_title = sub_title;
        this.color = color;
        this.notice = notice;
        this.description = description;
        this.card_details = card_details;
        this.cardType = cardType;
        this.quantity = quantity;
        this.dateType = dateType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.can_give_friend = can_give_friend;
    }

    public CreateCardVo() {
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isCan_give_friend() {
        return can_give_friend;
    }

    public void setCan_give_friend(boolean can_give_friend) {
        this.can_give_friend = can_give_friend;
    }
}