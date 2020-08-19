package com.zk.system.domain.weixin.domain.req;

import java.util.List;

/**
 * @Classname SetTestUser
 * @Description TODO 设置测试ID
 * @Date 2020/8/15 3:12 PM
 * @Created by nihui
 * @Version 1.0
 * @Description SetTestUser @see ruoyi
 */
public class SetTestUserRsq {
    private List<String> openid;
    private List<String> username;

    public SetTestUserRsq() {
    }

    public SetTestUserRsq(List<String> openid, List<String> username) {
        this.openid = openid;
        this.username = username;
    }

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }
}
