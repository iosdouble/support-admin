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

    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 是否转赠
     */
    private Integer can_give_friend = 0;


    /**
     * 每人限领
     */
    private Integer get_limit = 1;

    /**
     * 每人可核销
     */
    private Integer use_limit = 1;

    /**
     * 领取页面是否可分享
     */
    private Integer can_share = 0;

    public CreateCardVo() {
    }

    public CreateCardVo(String logo_url, String brandName, String title, String sub_title, String color, String notice, String description, String card_details, String cardType, Integer quantity, String dateType, String startTime, String endTime, Integer can_give_friend, Integer get_limit, Integer use_limit, Integer can_share) {
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
        this.get_limit = get_limit;
        this.use_limit = use_limit;
        this.can_share = can_share;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCan_give_friend() {
        return can_give_friend;
    }

    public void setCan_give_friend(Integer can_give_friend) {
        this.can_give_friend = can_give_friend;
    }

    public Integer getGet_limit() {
        return get_limit;
    }

    public void setGet_limit(Integer get_limit) {
        this.get_limit = get_limit;
    }

    public Integer getUse_limit() {
        return use_limit;
    }

    public void setUse_limit(Integer use_limit) {
        this.use_limit = use_limit;
    }

    public Integer getCan_share() {
        return can_share;
    }

    public void setCan_share(Integer can_share) {
        this.can_share = can_share;
    }
}