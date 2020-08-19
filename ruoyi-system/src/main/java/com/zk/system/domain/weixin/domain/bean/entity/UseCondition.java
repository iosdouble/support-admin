package com.zk.system.domain.weixin.domain.bean.entity;

/**
 * @Classname UseCondition
 * @Description TODO
 * @Date 2020/8/14 4:56 PM
 * @Created by nihui
 * @Version 1.0
 * @Description UseCondition @see ruoyi
 */
public class UseCondition {
    // 指定可用的商品类目
    private String accept_category;
    // 指定不可用的商品类目
    private String reject_category;

    // 满减门槛字段
    private Integer least_cost;

    // 可用门槛
    private String object_use_for;

    // 是否可共享优惠
    private boolean can_use_with_other_discount;


}
