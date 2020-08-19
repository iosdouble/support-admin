package com.zk.system.domain.weixin.domain.req;

import java.util.List;

/**
 * @Classname InputCode
 * @Description TODO 导入自定义Code
 * @Date 2020/8/14 5:36 PM
 * @Created by nihui
 * @Version 1.0
 * @Description InputCode @see ruoyi
 */
public class InputCodeRsq {
    private String card_id;
    private List<String> code;

    public InputCodeRsq(String card_id, List<String> code) {
        this.card_id = card_id;
        this.code = code;
    }

    public InputCodeRsq() {
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }
}
