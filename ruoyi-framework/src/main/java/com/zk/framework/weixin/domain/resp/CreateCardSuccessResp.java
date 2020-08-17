package com.zk.framework.weixin.domain.resp;

/**
 * @Classname CreateCardSuccessResp
 * @Description TODO
 * @Date 2020/8/15 3:59 PM
 * @Created by nihui
 * @Version 1.0
 * @Description CreateCardSuccessResp @see ruoyi
 */
public class CreateCardSuccessResp {
    private Integer errcode;
    private String errmsg;
    private String card_id;

    public CreateCardSuccessResp(Integer errcode, String errmsg, String card_id) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.card_id = card_id;
    }


    public CreateCardSuccessResp() {
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

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
