package com.zk.system.domain;

import java.util.Date;

public class WxkqCreateCardDetailsInfo {
    private Long id;

    private Long optionId;

    private String cardType;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Integer delFlag;

    private Integer status;

    private String createParameterDetail;

    public WxkqCreateCardDetailsInfo(Long id, Long optionId, String cardType, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, Integer delFlag, Integer status, String createParameterDetail) {
        this.id = id;
        this.optionId = optionId;
        this.cardType = cardType;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.delFlag = delFlag;
        this.status = status;
        this.createParameterDetail = createParameterDetail;
    }

    public WxkqCreateCardDetailsInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
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

    public String getCreateParameterDetail() {
        return createParameterDetail;
    }

    public void setCreateParameterDetail(String createParameterDetail) {
        this.createParameterDetail = createParameterDetail == null ? null : createParameterDetail.trim();
    }
}