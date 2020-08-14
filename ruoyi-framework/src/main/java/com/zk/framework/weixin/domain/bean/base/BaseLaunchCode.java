package com.zk.framework.weixin.domain.bean.base;

import com.zk.framework.weixin.domain.bean.entity.ActionInfo;

/**
 * @Classname BaseLaunchCode
 * @Description TODO
 * @Date 2020/8/14 5:19 PM
 * @Created by nihui
 * @Version 1.0
 * @Description BaseLaunchCode @see ruoyi
 */
public abstract class BaseLaunchCode {
    private String action_name;
    private Long expire_seconds;
    private ActionInfo action_info;
}
