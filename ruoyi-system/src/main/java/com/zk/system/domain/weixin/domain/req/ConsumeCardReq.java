package com.zk.system.domain.weixin.domain.req;

/**
 * @Classname ConsumeCardReq
 * @Description TODO 核销卡券的请求
 * @Date 2020/8/18 9:34 AM
 * @Created by nihui
 * @Version 1.0
 * @Description ConsumeCardReq @see ruoyi
 */
public class ConsumeCardReq {

    private String card_id;
    private String code;

    public ConsumeCardReq(String card_id, String code) {
        this.card_id = card_id;
        this.code = code;
    }

    public ConsumeCardReq() {
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
}
