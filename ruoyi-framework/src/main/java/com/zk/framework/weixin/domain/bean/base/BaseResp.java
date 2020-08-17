package com.zk.framework.weixin.domain.bean.base;

/**
 * @Classname BaseResp
 * @Description TODO
 * @Date 2020/8/15 2:28 PM
 * @Created by nihui
 * @Version 1.0
 * @Description BaseResp @see ruoyi
 */
public abstract class BaseResp {
    private Integer errcode;
    private String errmsg;

    public BaseResp(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public BaseResp() {
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
}
