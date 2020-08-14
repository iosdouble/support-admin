package com.zk.framework.weixin.domain;

/**
 * @Classname GroupOn
 * @Description TODO
 * @Date 2020/8/14 5:40 PM
 * @Created by nihui
 * @Version 1.0
 * @Description GroupOn @see ruoyi
 */
public class GroupOn {
    private CodeInfo base_info;
    private AdvancedCodeInfo advanced_info;
    private String deal_detail;

    public GroupOn(CodeInfo base_info, AdvancedCodeInfo advanced_info, String deal_detail) {
        this.base_info = base_info;
        this.advanced_info = advanced_info;
        this.deal_detail = deal_detail;
    }


    public GroupOn() {
    }


    public CodeInfo getBase_info() {
        return base_info;
    }

    public void setBase_info(CodeInfo base_info) {
        this.base_info = base_info;
    }

    public AdvancedCodeInfo getAdvanced_info() {
        return advanced_info;
    }

    public void setAdvanced_info(AdvancedCodeInfo advanced_info) {
        this.advanced_info = advanced_info;
    }

    public String getDeal_detail() {
        return deal_detail;
    }

    public void setDeal_detail(String deal_detail) {
        this.deal_detail = deal_detail;
    }
}
