package com.zk.system.domain.weixin.accesstoken;

/**
 * @Classname WeixinConnection
 * @Description TODO
 * @Date 2020/8/14 3:19 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WeixinConnection @see ruoyi
 */
public class WeixinConnection {
    private String url;
    private String appid;
    private String secret;

    public WeixinConnection(String url, String appid, String secret) {
        this.url = url;
        this.appid = appid;
        this.secret = secret;
    }

    public WeixinConnection() {
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
