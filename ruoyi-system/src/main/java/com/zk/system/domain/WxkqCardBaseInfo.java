package com.zk.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

public class WxkqCardBaseInfo implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;


    private String cardId;

    private String codeType;

    private String brandName;

    private String title;

    private Integer quantity;

    private Integer useCustomCode;

    private String getCustomCodeMode;

    private Date beginTimeStamp;

    private Date endTimeStamp;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Integer delFlag;

    private Integer status;

    public WxkqCardBaseInfo(Long id, String cardId, String codeType, String brandName, String title, Integer quantity, Integer useCustomCode, String getCustomCodeMode, Date beginTimeStamp, Date endTimeStamp, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, Integer delFlag, Integer status) {
        this.id = id;
        this.cardId = cardId;
        this.codeType = codeType;
        this.brandName = brandName;
        this.title = title;
        this.quantity = quantity;
        this.useCustomCode = useCustomCode;
        this.getCustomCodeMode = getCustomCodeMode;
        this.beginTimeStamp = beginTimeStamp;
        this.endTimeStamp = endTimeStamp;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.delFlag = delFlag;
        this.status = status;
    }

    public WxkqCardBaseInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUseCustomCode() {
        return useCustomCode;
    }

    public void setUseCustomCode(Integer useCustomCode) {
        this.useCustomCode = useCustomCode;
    }

    public String getGetCustomCodeMode() {
        return getCustomCodeMode;
    }

    public void setGetCustomCodeMode(String getCustomCodeMode) {
        this.getCustomCodeMode = getCustomCodeMode == null ? null : getCustomCodeMode.trim();
    }

    public Date getBeginTimeStamp() {
        return beginTimeStamp;
    }

    public void setBeginTimeStamp(Date beginTimeStamp) {
        this.beginTimeStamp = beginTimeStamp;
    }

    public Date getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(Date endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
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