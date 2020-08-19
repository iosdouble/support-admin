package com.zk.system.domain.weixin.domain.resp;

import com.zk.system.domain.weixin.domain.bean.entity.CardDetail;

/**
 * @Classname GetCardDetailSuccessResp
 * @Description TODO
 * @Date 2020/8/18 9:17 AM
 * @Created by nihui
 * @Version 1.0
 * @Description GetCardDetailSuccessResp @see ruoyi
 */
public class GetCardDetailSuccessResp {

    private Integer errcode;
    private String errmsg;

    private CardDetail card;

    private String openid;

    private Boolean can_consume;

    private String user_card_status;

    private String outer_str;

    private String unionid;

    public GetCardDetailSuccessResp() {
    }

    public GetCardDetailSuccessResp(Integer errcode, String errmsg, CardDetail card, String openid, Boolean can_consume, String user_card_status, String outer_str, String unionid) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.card = card;
        this.openid = openid;
        this.can_consume = can_consume;
        this.user_card_status = user_card_status;
        this.outer_str = outer_str;
        this.unionid = unionid;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public CardDetail getCard() {
        return card;
    }

    public void setCard(CardDetail card) {
        this.card = card;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Boolean getCan_consume() {
        return can_consume;
    }

    public void setCan_consume(Boolean can_consume) {
        this.can_consume = can_consume;
    }

    public String getUser_card_status() {
        return user_card_status;
    }

    public void setUser_card_status(String user_card_status) {
        this.user_card_status = user_card_status;
    }

    public String getOuter_str() {
        return outer_str;
    }

    public void setOuter_str(String outer_str) {
        this.outer_str = outer_str;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
