package com.zk.system.domain.weixin.domain.bean.entity;

/**
 * @Classname CardDetail
 * @Description TODO
 * @Date 2020/8/18 9:18 AM
 * @Created by nihui
 * @Version 1.0
 * @Description CardDetail @see ruoyi
 */
public class CardDetail {
    private String card_id;
    private Long begin_time;
    private Long end_time;
    private String code;

    public CardDetail() {
    }

    public CardDetail(String card_id, Long begin_time, Long end_time, String code) {
        this.card_id = card_id;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.code = code;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public Long getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Long begin_time) {
        this.begin_time = begin_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
