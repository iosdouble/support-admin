package com.zk.framework.weixin.domain.bean.base;

import com.zk.framework.weixin.domain.bean.entity.DateInfo;
import com.zk.framework.weixin.domain.bean.entity.SKU;

/**
 * @Classname BaseCodeInfo
 * @Description TODO
 * @Date 2020/8/14 4:13 PM
 * @Created by nihui
 * @Version 1.0
 * @Description BaseCodeInfo @see ruoyi
 */
public abstract class BaseCodeInfo {
    // 卡券商户logo
    private String logo_url;
    //码型
    private String code_type;
    // 商户名称
    private String brand_name;
    // 卡券名
    private String name;
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
    // 失效时间
    private Integer fixed_term;
    // 生效时间
    private Integer fixed_begin_term;


    public BaseCodeInfo(String logo_url, String code_type, String brand_name, String name, String color, String notice, String description, SKU sku, DateInfo date_info, Integer fixed_term, Integer fixed_begin_term) {
        this.logo_url = logo_url;
        this.code_type = code_type;
        this.brand_name = brand_name;
        this.name = name;
        this.color = color;
        this.notice = notice;
        this.description = description;
        this.sku = sku;
        this.date_info = date_info;
        this.fixed_term = fixed_term;
        this.fixed_begin_term = fixed_begin_term;
    }

    public BaseCodeInfo() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getFixed_term() {
        return fixed_term;
    }

    public void setFixed_term(Integer fixed_term) {
        this.fixed_term = fixed_term;
    }

    public Integer getFixed_begin_term() {
        return fixed_begin_term;
    }

    public void setFixed_begin_term(Integer fixed_begin_term) {
        this.fixed_begin_term = fixed_begin_term;
    }
}
