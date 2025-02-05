package com.zk.system.domain.weixin.domain.bean.base;

import com.zk.system.domain.weixin.domain.bean.entity.DateInfo;
import com.zk.system.domain.weixin.domain.bean.entity.SKU;

/**
 * @Classname BaseCodeInfo
 * @Description TODO
 * @Date 2020/8/14 4:13 PM
 * @Created by nihui
 * @Version 1.0
 * @Description BaseCodeInfo @see ruoyi
 */
public  class BaseCodeInfo {
    // 卡券商户logo
    private String logo_url;
    //码型
    private String code_type;
    // 商户名称
    private String brand_name;

    //是否支持默认自定义Code 默认是false
    private boolean use_custom_code = false;

    //
//    private String get_custom_code_mode = "GET_CUSTOM_CODE_MODE_DEPOSIT";
    // 卡券名
    private String title;
    // 卡券颜色
    private String color;
    // 卡券使用提醒
    private String notice;
    // 卡券适用说明
    private String description;
    // 商品信息
    private SKU sku;
    // 使用日期
    private DateInfo date_info;

    /**
     * 使用限制
     */
    private Integer use_limit = 1;

    /**
     * 领取限制
     */
    private Integer get_limit = 1;

    /**
     * 是否可分享
     */
    private Boolean can_share = false;

    /**
     * 是否可转赠
     */
    private Boolean can_give_friend = false;

    public BaseCodeInfo() {
    }

    public BaseCodeInfo(String logo_url, String code_type, String brand_name, boolean use_custom_code, String get_custom_code_mode, String title, String color, String notice, String description, SKU sku, DateInfo date_info, Integer use_limit, Integer get_limit, Boolean can_share, Boolean can_give_friend) {
        this.logo_url = logo_url;
        this.code_type = code_type;
        this.brand_name = brand_name;
        this.use_custom_code = use_custom_code;
//        this.get_custom_code_mode = get_custom_code_mode;
        this.title = title;
        this.color = color;
        this.notice = notice;
        this.description = description;
        this.sku = sku;
        this.date_info = date_info;
        this.use_limit = use_limit;
        this.get_limit = get_limit;
        this.can_share = can_share;
        this.can_give_friend = can_give_friend;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public boolean isUse_custom_code() {
        return use_custom_code;
    }

    public void setUse_custom_code(boolean use_custom_code) {
        this.use_custom_code = use_custom_code;
    }

//    public String getGet_custom_code_mode() {
//        return get_custom_code_mode;
//    }
//
//    public void setGet_custom_code_mode(String get_custom_code_mode) {
//        this.get_custom_code_mode = get_custom_code_mode;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public SKU getSku() {
        return sku;
    }

    public void setSku(SKU sku) {
        this.sku = sku;
    }

    public DateInfo getDate_info() {
        return date_info;
    }

    public void setDate_info(DateInfo date_info) {
        this.date_info = date_info;
    }

    public Integer getUse_limit() {
        return use_limit;
    }

    public void setUse_limit(Integer use_limit) {
        this.use_limit = use_limit;
    }

    public Integer getGet_limit() {
        return get_limit;
    }

    public void setGet_limit(Integer get_limit) {
        this.get_limit = get_limit;
    }

    public Boolean getCan_share() {
        return can_share;
    }

    public void setCan_share(Boolean can_share) {
        this.can_share = can_share;
    }

    public Boolean getCan_give_friend() {
        return can_give_friend;
    }

    public void setCan_give_friend(Boolean can_give_friend) {
        this.can_give_friend = can_give_friend;
    }
}
