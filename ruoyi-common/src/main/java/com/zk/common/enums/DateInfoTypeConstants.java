package com.zk.common.enums;

/**
 * @Classname DateInfoTypeConstants
 * @Description TODO
 * @Date 2020/8/18 6:10 PM
 * @Created by nihui
 * @Version 1.0
 * @Description DateInfoTypeConstants @see ruoyi
 */
public enum DateInfoTypeConstants {

    DATE_TYPE_FIXTIME_RANGE(0, "DATE_TYPE_FIXTIME_RANGE"), DATE_TYPEFIXE_TERM(1, "DATE_TYPEFIXE_TERM");

    private final Integer code;
    private final String info;

    DateInfoTypeConstants(Integer code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
