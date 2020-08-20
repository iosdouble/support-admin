package com.zk.system.domain.weixin.domain.bean.entity;

/**
 * @Classname Banner
 * @Description TODO 创建卡券货架
 * @Date 2020/8/19 3:11 PM
 * @Created by nihui
 * @Version 1.0
 * @Description Banner @see ruoyi
 */
public class CardItem {

    private String card_id;
    private String thumb_url;

    public CardItem(String card_id, String thumb_url) {
        this.card_id = card_id;
        this.thumb_url = thumb_url;
    }


    public CardItem() {
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }
}
