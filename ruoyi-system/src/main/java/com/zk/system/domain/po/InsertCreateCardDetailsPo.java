package com.zk.system.domain.po;

/**
 * @Classname InsertCreateCardDetailsPo
 * @Description TODO
 * @Date 2020/8/18 10:07 PM
 * @Created by nihui
 * @Version 1.0
 * @Description InsertCreateCardDetailsPo @see ruoyi
 */
public class InsertCreateCardDetailsPo {

    // 卡券类型
    private String cardType;
    // 请求详情
    private String detail;
    // 创建人
    private String createBy;

    public InsertCreateCardDetailsPo(String cardType, String detail, String createBy) {
        this.cardType = cardType;
        this.detail = detail;
        this.createBy = createBy;
    }

    public InsertCreateCardDetailsPo() {
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
