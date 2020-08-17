package com.zk.framework.weixin.domain.bean;

import com.zk.framework.weixin.domain.req.CardRsq;

/**
 * @Classname CreateCard
 * @Description TODO 创建卡券实体类
 * @Date 2020/8/15 9:25 AM
 * @Created by nihui
 * @Version 1.0
 * @Description CreateCard @see ruoyi
 */
public class CreateCard {
    private CardRsq card;

    public CreateCard(CardRsq card) {
        this.card = card;
    }
    public CreateCard(){

    }

    public CardRsq getCard() {
        return card;
    }

    public void setCard(CardRsq card) {
        this.card = card;
    }
}
