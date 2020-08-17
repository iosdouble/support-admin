package com.zk.framework.weixin.domain.req;

import com.zk.framework.weixin.domain.bean.GroupOn;

/**
 * @Classname Card
 * @Description TODO 创建卡券内容体
 * @Date 2020/8/14 5:39 PM
 * @Created by nihui
 * @Version 1.0
 * @Description Card @see ruoyi
 */
public class CardRsq {
    private String card_type;

    private GroupOn groupon;

    public CardRsq(String card_type, GroupOn groupon) {
        this.card_type = card_type;
        this.groupon = groupon;
    }

    public CardRsq() {
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public GroupOn getGroupon() {
        return groupon;
    }

    public void setGroupon(GroupOn groupon) {
        this.groupon = groupon;
    }
}
