package com.zk.framework.weixin.domain;

import com.zk.framework.weixin.domain.bean.entity.Abstract;
import com.zk.framework.weixin.domain.bean.entity.TextImageItem;
import com.zk.framework.weixin.domain.bean.entity.TimeLimitItem;
import com.zk.framework.weixin.domain.bean.entity.UseCondition;

import java.util.List;

/**
 * @Classname AdvancedCodeInfo
 * @Description TODO
 * @Date 2020/8/14 4:54 PM
 * @Created by nihui
 * @Version 1.0
 * @Description AdvancedCodeInfo @see ruoyi
 */
public class AdvancedCodeInfo  {
    // 使用条件
    private UseCondition user_condition;

    // 封面摘要结构体名称

    private Abstract anAbstract;

    // 图文列表
    private List<TextImageItem> text_image_list;

    //商家服务类型
    private List<String> business_service;

    private List<TimeLimitItem> time_limit;

    public AdvancedCodeInfo(UseCondition user_condition, Abstract anAbstract, List<TextImageItem> text_image_list, List<String> business_service, List<TimeLimitItem> time_limit) {
        this.user_condition = user_condition;
        this.anAbstract = anAbstract;
        this.text_image_list = text_image_list;
        this.business_service = business_service;
        this.time_limit = time_limit;

    }

    public AdvancedCodeInfo() {
    }

    public UseCondition getUser_condition() {
        return user_condition;
    }

    public void setUser_condition(UseCondition user_condition) {
        this.user_condition = user_condition;
    }

    public Abstract getAnAbstract() {
        return anAbstract;
    }

    public void setAnAbstract(Abstract anAbstract) {
        this.anAbstract = anAbstract;
    }

    public List<TextImageItem> getText_image_list() {
        return text_image_list;
    }

    public void setText_image_list(List<TextImageItem> text_image_list) {
        this.text_image_list = text_image_list;
    }

    public List<String> getBusiness_service() {
        return business_service;
    }

    public void setBusiness_service(List<String> business_service) {
        this.business_service = business_service;
    }

    public List<TimeLimitItem> getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(List<TimeLimitItem> time_limit) {
        this.time_limit = time_limit;
    }
}

