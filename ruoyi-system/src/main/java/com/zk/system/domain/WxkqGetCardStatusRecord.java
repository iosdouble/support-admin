package com.zk.system.domain;

import java.util.Date;

public class WxkqGetCardStatusRecord {
    private Long id;

    private Integer errcode;

    private String errmsg;

    private String cardId;

    private String beginTime;

    private String endTime;

    private Long code;

    private String openid;

    private Integer canConsume;

    private Integer userCardStatus;

    private String outerStr;

    private String unionid;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Integer delFlag;

    private Integer status;

    public WxkqGetCardStatusRecord(Long id, Integer errcode, String errmsg, String cardId, String beginTime, String endTime, Long code, String openid, Integer canConsume, Integer userCardStatus, String outerStr, String unionid, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, Integer delFlag, Integer status) {
        this.id = id;
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.cardId = cardId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.code = code;
        this.openid = openid;
        this.canConsume = canConsume;
        this.userCardStatus = userCardStatus;
        this.outerStr = outerStr;
        this.unionid = unionid;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.delFlag = delFlag;
        this.status = status;
    }

    public WxkqGetCardStatusRecord() {
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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getCanConsume() {
        return canConsume;
    }

    public void setCanConsume(Integer canConsume) {
        this.canConsume = canConsume;
    }

    public Integer getUserCardStatus() {
        return userCardStatus;
    }

    public void setUserCardStatus(Integer userCardStatus) {
        this.userCardStatus = userCardStatus;
    }

    public String getOuterStr() {
        return outerStr;
    }

    public void setOuterStr(String outerStr) {
        this.outerStr = outerStr == null ? null : outerStr.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
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