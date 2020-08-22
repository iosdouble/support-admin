package com.zk.system.domain;

import java.util.Date;

public class GhNewsResWithBLOBs extends GhNewsRes {
    private String newTitle;

    private String newContext;

    public GhNewsResWithBLOBs(Long newId, Long applyUserCode, Long deptCode, String applyDateTime, Date createTime, Date updateTime, String deptName, Integer status, Integer delFlag, String newTitle, String newContext) {
        super(newId, applyUserCode, deptCode, applyDateTime, createTime, updateTime, deptName, status, delFlag);
        this.newTitle = newTitle;
        this.newContext = newContext;
    }

    public GhNewsResWithBLOBs() {
        super();
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle == null ? null : newTitle.trim();
    }

    public String getNewContext() {
        return newContext;
    }

    public void setNewContext(String newContext) {
        this.newContext = newContext == null ? null : newContext.trim();
    }
}