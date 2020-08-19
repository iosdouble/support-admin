package com.zk.system.domain.weixin.domain.resp;

import com.zk.system.domain.weixin.domain.bean.base.BaseResp;

/**
 * @Classname LaunchCardSuccessResp
 * @Description TODO
 * @Date 2020/8/15 2:28 PM
 * @Created by nihui
 * @Version 1.0
 * @Description LaunchCardSuccessResp @see ruoyi
 */
public class LaunchCardSuccessResp extends BaseResp {
    // 获取 的二维码 ticket
    private String ticket;
    // 有效时间
    private Integer expire_seconds;
    // 二维码图片解析后的地址，可以根据这个地址自行生成需要的二维码图片
    private String url;
    // 二维码显示地址，点击之后跳转二维码
    private String show_qrcode_url;

    public LaunchCardSuccessResp(Integer errcode, String errmsg, String ticket, Integer expire_seconds, String url, String show_qrcode_url) {
        super(errcode, errmsg);
        this.ticket = ticket;
        this.expire_seconds = expire_seconds;
        this.url = url;
        this.show_qrcode_url = show_qrcode_url;
    }

    public LaunchCardSuccessResp() {
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(Integer expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShow_qrcode_url() {
        return show_qrcode_url;
    }

    public void setShow_qrcode_url(String show_qrcode_url) {
        this.show_qrcode_url = show_qrcode_url;
    }
}
