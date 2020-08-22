package com.zk.system.domain.vo;

/**
 * @Classname CreateNewsVo
 * @Description TODO
 * @Date 2020/8/22 9:40 AM
 * @Created by nihui
 * @Version 1.0
 * @Description CreateNewsVo @see ruoyi
 */
public class CreateNewsVo {
    private String title;
    private String value;

    public CreateNewsVo() {
    }

    public CreateNewsVo(String title, String value) {
        this.title = title;
        this.value = value;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
