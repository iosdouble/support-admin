package com.zk.system.domain.weixin.domain.req;

import com.zk.system.domain.weixin.domain.bean.entity.CardItem;

import java.util.List;

/**
 * @Classname CardShopRsq
 * @Description TODO
 * @Date 2020/8/19 3:13 PM
 * @Created by nihui
 * @Version 1.0
 * @Description CardShopRsq @see ruoyi
 */
public class CardShopRsq {

    // 页面图片
    private String banner;
    // 页面title
    private String page_title;
    // 是否可分享
    private Boolean can_share;
    // 场景值
    private String scene;

    // 卡券列表
    private List<CardItem> card_list;


    public CardShopRsq() {
    }

    public CardShopRsq(String banner, String page_title, Boolean can_share, String scene, List<CardItem> card_list) {
        this.banner = banner;
        this.page_title = page_title;
        this.can_share = can_share;
        this.scene = scene;
        this.card_list = card_list;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public Boolean getCan_share() {
        return can_share;
    }

    public void setCan_share(Boolean can_share) {
        this.can_share = can_share;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public List<CardItem> getCard_list() {
        return card_list;
    }

    public void setCard_list(List<CardItem> card_list) {
        this.card_list = card_list;
    }
}
