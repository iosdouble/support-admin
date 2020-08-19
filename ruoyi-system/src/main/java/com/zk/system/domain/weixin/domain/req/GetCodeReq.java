package com.zk.system.domain.weixin.domain.req;

/**
 * @Classname GetCodeReq
 * @Description TODO
 * @Date 2020/8/15 4:54 PM
 * @Created by nihui
 * @Version 1.0
 * @Description GetCodeReq @see ruoyi
 */
public class GetCodeReq {
    private String card_id;

    public GetCodeReq(String card_id) {
        this.card_id = card_id;
    }

    public GetCodeReq() {
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
