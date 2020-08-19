package com.zk.system.domain.weixin.domain.bean.entity;

/**
 * @Classname DateInfo
 * @Description TODO
 * @Date 2020/8/14 4:19 PM
 * @Created by nihui
 * @Version 1.0
 * @Description DateInfo @see ruoyi
 */
public class DateInfo {
    // 时间类型
    private String type;
    // 开始时间戳
    private Long begin_timestamp;
    // 结束时间戳
    private Long end_timestamp;


    public DateInfo(String type, Long begin_timestamp, Long end_timestamp) {
        this.type = type;
        this.begin_timestamp = begin_timestamp;
        this.end_timestamp = end_timestamp;
    }

    public DateInfo() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBegin_timestamp() {
        return begin_timestamp;
    }

    public void setBegin_timestamp(Long begin_timestamp) {
        this.begin_timestamp = begin_timestamp;
    }

    public Long getEnd_timestamp() {
        return end_timestamp;
    }

    public void setEnd_timestamp(Long end_timestamp) {
        this.end_timestamp = end_timestamp;
    }
}