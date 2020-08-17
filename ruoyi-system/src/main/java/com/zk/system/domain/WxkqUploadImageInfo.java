package com.zk.system.domain;

import java.util.Date;

public class WxkqUploadImageInfo {
    private Integer id;

    private String imageName;

    private String imageUrl;

    private String imageUse;

    private String imageBusiness;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Integer delFlag;

    private Integer status;

    private String remark;

    public WxkqUploadImageInfo(Integer id, String imageName, String imageUrl, String imageUse, String imageBusiness, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, Integer delFlag, Integer status, String remark) {
        this.id = id;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.imageUse = imageUse;
        this.imageBusiness = imageBusiness;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.delFlag = delFlag;
        this.status = status;
        this.remark = remark;
    }

    public WxkqUploadImageInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageUse() {
        return imageUse;
    }

    public void setImageUse(String imageUse) {
        this.imageUse = imageUse == null ? null : imageUse.trim();
    }

    public String getImageBusiness() {
        return imageBusiness;
    }

    public void setImageBusiness(String imageBusiness) {
        this.imageBusiness = imageBusiness == null ? null : imageBusiness.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}