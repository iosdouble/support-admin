package com.zk.system.domain.weixin.domain.bean.entity;

/**
 * @Classname ActionInfo
 * @Description TODO
 * @Date 2020/8/14 5:31 PM
 * @Created by nihui
 * @Version 1.0
 * @Description ActionInfo @see ruoyi
 */
public class ActionInfo {
    private Card card;

    public ActionInfo(Card card) {
        this.card = card;
    }

    public ActionInfo() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
