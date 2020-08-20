package com.zk.system.domain.po;

import java.util.Date;

/**
 * @Classname InsertCardBaseInfoPo
 * @Description TODO
 * @Date 2020/8/19 6:01 PM
 * @Created by nihui
 * @Version 1.0
 * @Description InsertCardBaseInfoPo @see ruoyi
 */
public class InsertCardBaseInfoPo {
    private String card_id;
    private String code_type;
    private String brand_name;
    private String title;
    private Integer quantity;
    private Boolean use_custom_code;
    private String get_custom_code_mode;
    private Date begin_time_stamp;
    private Date end_time_stamp;
    private String urser_name;

    public InsertCardBaseInfoPo() {
    }

    public InsertCardBaseInfoPo(String card_id, String code_type, String brand_name, String title, Integer quantity, Boolean use_custom_code, String get_custom_code_mode, Date begin_time_stamp, Date end_time_stamp, String urser_name) {
        this.card_id = card_id;
        this.code_type = code_type;
        this.brand_name = brand_name;
        this.title = title;
        this.quantity = quantity;
        this.use_custom_code = use_custom_code;
        this.get_custom_code_mode = get_custom_code_mode;
        this.begin_time_stamp = begin_time_stamp;
        this.end_time_stamp = end_time_stamp;
        this.urser_name = urser_name;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getUse_custom_code() {
        return use_custom_code;
    }

    public void setUse_custom_code(Boolean use_custom_code) {
        this.use_custom_code = use_custom_code;
    }

    public String getGet_custom_code_mode() {
        return get_custom_code_mode;
    }

    public void setGet_custom_code_mode(String get_custom_code_mode) {
        this.get_custom_code_mode = get_custom_code_mode;
    }

    public Date getBegin_time_stamp() {
        return begin_time_stamp;
    }

    public void setBegin_time_stamp(Date begin_time_stamp) {
        this.begin_time_stamp = begin_time_stamp;
    }

    public Date getEnd_time_stamp() {
        return end_time_stamp;
    }

    public void setEnd_time_stamp(Date end_time_stamp) {
        this.end_time_stamp = end_time_stamp;
    }

    public String getUrser_name() {
        return urser_name;
    }

    public void setUrser_name(String urser_name) {
        this.urser_name = urser_name;
    }
}
