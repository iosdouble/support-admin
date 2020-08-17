package com.zk.system.domain;

import java.util.Date;

public class WxkqLaunchCardRecord {
    private Long id;

    private Integer errcode;

    private String errmsg;

    private String ticket;

    private Integer expireSeconds;

    private String url;

    private String showQrcodeUrl;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer delFlag;

    private Integer status;

    public WxkqLaunchCardRecord(Long id, Integer errcode, String errmsg, String ticket, Integer expireSeconds, String url, String showQrcodeUrl, Date createTime, Date lastUpdateTime, Integer delFlag, Integer status) {
        this.id = id;
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.ticket = ticket;
        this.expireSeconds = expireSeconds;
        this.url = url;
        this.showQrcodeUrl = showQrcodeUrl;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.delFlag = delFlag;
        this.status = status;
    }

    public WxkqLaunchCardRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.errmsg = errmsg == null ? null : errmsg.trim();
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getShowQrcodeUrl() {
        return showQrcodeUrl;
    }

    public void setShowQrcodeUrl(String showQrcodeUrl) {
        this.showQrcodeUrl = showQrcodeUrl == null ? null : showQrcodeUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}