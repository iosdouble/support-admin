package com.zk.framework.weixin;

import com.zk.framework.weixin.domain.GroupOn;

/**
 * @Classname Card
 * @Description TODO
 * @Date 2020/8/14 5:39 PM
 * @Created by nihui
 * @Version 1.0
 * @Description Card @see ruoyi
 */
public class Card {
    private String card_tyep;

    private GroupOn groupon;

    public Card(String card_tyep, GroupOn groupon) {
        this.card_tyep = card_tyep;
        this.groupon = groupon;
    }

    public Card() {
    }

    public String getCard_tyep() {
        return card_tyep;
    }

    public void setCard_tyep(String card_tyep) {
        this.card_tyep = card_tyep;
    }

    public GroupOn getGroupon() {
        return groupon;
    }

    public void setGroupon(GroupOn groupon) {
        this.groupon = groupon;
    }
}
