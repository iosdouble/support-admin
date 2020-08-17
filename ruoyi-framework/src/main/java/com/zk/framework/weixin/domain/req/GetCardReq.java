package com.zk.framework.weixin.domain.req;

/**
 * @Classname GetCardReq
 * @Description TODO
 * @Date 2020/8/15 4:38 PM
 * @Created by nihui
 * @Version 1.0
 * @Description GetCardReq @see ruoyi
 */
public class GetCardReq {
    private String card_id;
    private String code;
    private boolean check_consume;

    public GetCardReq(String card_id, String code, boolean check_consume) {
        this.card_id = card_id;
        this.code = code;
        this.check_consume = check_consume;
    }

    public GetCardReq() {
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

    public boolean isCheck_consume() {
        return check_consume;
    }

    public void setCheck_consume(boolean check_consume) {
        this.check_consume = check_consume;
    }
}
