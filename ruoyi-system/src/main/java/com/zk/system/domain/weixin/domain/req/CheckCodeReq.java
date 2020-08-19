package com.zk.system.domain.weixin.domain.req;

import java.util.List;

/**
 * @Classname CheckCodeReq
 * @Description TODO
 * @Date 2020/8/15 5:08 PM
 * @Created by nihui
 * @Version 1.0
 * @Description CheckCodeReq @see ruoyi
 */
public class CheckCodeReq {
    private String card_id;
    private List<String> code;


    public CheckCodeReq() {
    }

    public CheckCodeReq(String card_id, List<String> code) {
        this.card_id = card_id;
        this.code = code;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }
}
