package com.zk.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

public class GhNewsRes implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long newId;

    private Long applyUserCode;

    private Long deptCode;

    private String applyDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createTime;

    private Date updateTime;

    private String deptName;

    private Integer status;

    private Integer delFlag;

    public GhNewsRes(Long newId, Long applyUserCode, Long deptCode, String applyDateTime, Date createTime, Date updateTime, String deptName, Integer status, Integer delFlag) {
        this.newId = newId;
        this.applyUserCode = applyUserCode;
        this.deptCode = deptCode;
        this.applyDateTime = applyDateTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deptName = deptName;
        this.status = status;
        this.delFlag = delFlag;
    }

    public GhNewsRes() {
        super();
    }

    public Long getNewId() {
        return newId;
    }

    public void setNewId(Long newId) {
        this.newId = newId;
    }

    public Long getApplyUserCode() {
        return applyUserCode;
    }

    public void setApplyUserCode(Long applyUserCode) {
        this.applyUserCode = applyUserCode;
    }

    public Long getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(Long deptCode) {
        this.deptCode = deptCode;
    }

    public String getApplyDateTime() {
        return applyDateTime;
    }

    public void setApplyDateTime(String applyDateTime) {
        this.applyDateTime = applyDateTime == null ? null : applyDateTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}