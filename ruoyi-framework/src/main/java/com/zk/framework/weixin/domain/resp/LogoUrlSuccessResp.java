package com.zk.framework.weixin.domain.resp;

/**
 * @Classname LogoUrlSuccessResp
 * @Description TODO
 * @Date 2020/8/17 4:30 PM
 * @Created by nihui
 * @Version 1.0
 * @Description LogoUrlSuccessResp @see ruoyi
 */
public class LogoUrlSuccessResp {
    private String url;

    public LogoUrlSuccessResp(String url) {
        this.url = url;
    }

    public LogoUrlSuccessResp() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
