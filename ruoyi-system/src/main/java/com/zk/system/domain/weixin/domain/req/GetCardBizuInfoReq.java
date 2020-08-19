package com.zk.system.domain.weixin.domain.req;

/**
 * @Classname GetCardBizuInfoReq
 * @Description TODO
 * @Date 2020/8/18 10:03 AM
 * @Created by nihui
 * @Version 1.0
 * @Description GetCardBizuInfoReq @see ruoyi
 */
public class GetCardBizuInfoReq {
    private String begin_date;
    private String end_date;
    private Integer cond_source;

    public GetCardBizuInfoReq(String begin_date, String end_date, Integer cond_source) {
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.cond_source = cond_source;
    }

    public GetCardBizuInfoReq() {
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Integer getCond_source() {
        return cond_source;
    }

    public void setCond_source(Integer cond_source) {
        this.cond_source = cond_source;
    }
}
