package com.zk.framework.weixin.domain.bean.entity;

/**
 * @Classname SKU
 * @Description TODO
 * @Date 2020/8/14 4:17 PM
 * @Created by nihui
 * @Version 1.0
 * @Description SKU @see ruoyi
 */
public class SKU {
    // 库存
    private Integer quantity;

    public SKU(Integer quantity) {
        this.quantity = quantity;
    }

    public SKU() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
