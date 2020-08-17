package com.zk.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WxkqCreateCardRecord {
    private Long id;

    private String cardType;

    private Integer useCustomCode;

    private Integer errcode;

    private String errmsg;

    private String cardId;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createTime;

    private Integer delFlag;

    private Integer status;

    public WxkqCreateCardRecord(Long id, String cardType, Integer useCustomCode, Integer errcode, String errmsg, String cardId, String createBy, Date createTime, Integer delFlag, Integer status) {
        this.id = id;
        this.cardType = cardType;
        this.useCustomCode = useCustomCode;
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.cardId = cardId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.delFlag = delFlag;
        this.status = status;
    }

    public WxkqCreateCardRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public Integer getUseCustomCode() {
        return useCustomCode;
    }

    public void setUseCustomCode(Integer useCustomCode) {
        this.useCustomCode = useCustomCode;
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