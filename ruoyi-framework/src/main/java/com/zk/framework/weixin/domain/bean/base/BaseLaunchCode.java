package com.zk.framework.weixin.domain.bean.base;

import com.zk.framework.weixin.domain.bean.entity.ActionInfo;

/**
 * @Classname BaseLaunchCode
 * @Description TODO
 * @Date 2020/8/14 5:19 PM
 * @Created by nihui
 * @Version 1.0
 * @Description BaseLaunchCode @see ruoyi
 */
public abstract class BaseLaunchCode {
    private String action_name;
    private Long expire_seconds;
    private ActionInfo action_info;

    public BaseLaunchCode(String action_name, Long expire_seconds, ActionInfo action_info) {
        this.action_name = action_name;
        this.expire_seconds = expire_seconds;
        this.action_info = action_info;
    }

    public BaseLaunchCode() {
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public Long getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(Long expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public ActionInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(ActionInfo action_info) {
        this.action_info = action_info;
    }
}
