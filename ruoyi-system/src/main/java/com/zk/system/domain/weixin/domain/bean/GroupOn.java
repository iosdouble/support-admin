package com.zk.system.domain.weixin.domain.bean;

import com.zk.system.domain.weixin.domain.bean.base.BaseCodeInfo;

/**
 * @Classname GroupOn
 * @Description TODO
 * @Date 2020/8/14 5:40 PM
 * @Created by nihui
 * @Version 1.0
 * @Description GroupOn @see ruoyi
 */
public class GroupOn {
    private BaseCodeInfo base_info;

    private String deal_detail;

    public GroupOn(CodeInfo base_info, String deal_detail) {
        this.base_info = base_info;

        this.deal_detail = deal_detail;
    }


    public GroupOn(BaseCodeInfo base_info, String deal_detail) {
        this.base_info = base_info;
        this.deal_detail = deal_detail;
    }

    public GroupOn() {
    }


    public BaseCodeInfo getBase_info() {
        return base_info;
    }

    public void setBase_info(BaseCodeInfo base_info) {
        this.base_info = base_info;
    }

    public String getDeal_detail() {
        return deal_detail;
    }

    public void setDeal_detail(String deal_detail) {
        this.deal_detail = deal_detail;
    }
}
