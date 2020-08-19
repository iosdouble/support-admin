package com.zk.system.domain.weixin.domain.vo;

/**
 * @Classname InputCodeVo
 * @Description TODO
 * @Date 2020/8/17 5:57 PM
 * @Created by nihui
 * @Version 1.0
 * @Description InputCodeVo @see ruoyi
 */
public class InputCodeVo {
    private String card_id;
    private Integer quantity;

    public InputCodeVo(String card_id, Integer quantity) {
        this.card_id = card_id;
        this.quantity = quantity;
    }


    public InputCodeVo() {
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
