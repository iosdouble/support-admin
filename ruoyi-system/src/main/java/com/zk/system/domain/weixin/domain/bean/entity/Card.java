package com.zk.system.domain.weixin.domain.bean.entity;

/**
 * @Classname Card
 * @Description TODO
 * @Date 2020/8/14 5:31 PM
 * @Created by nihui
 * @Version 1.0
 * @Description Card @see ruoyi
 */
public class Card {
    private String card_id;
    private String code;
    private String openid;
    private boolean is_unique_code;
    private String outer_str;


    public Card(String card_id, String code, String openid, boolean is_unique_code, String outer_str) {
        this.card_id = card_id;
        this.code = code;
        this.openid = openid;
        this.is_unique_code = is_unique_code;
        this.outer_str = outer_str;
    }

    public Card() {
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public boolean isIs_unique_code() {
        return is_unique_code;
    }

    public void setIs_unique_code(boolean is_unique_code) {
        this.is_unique_code = is_unique_code;
    }

    public String getOuter_str() {
        return outer_str;
    }

    public void setOuter_str(String outer_str) {
        this.outer_str = outer_str;
    }
}
