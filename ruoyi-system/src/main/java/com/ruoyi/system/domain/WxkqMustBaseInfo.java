package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 微信卡券基础信息必填信息 对象 wxkq_must_base_info
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
public class WxkqMustBaseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 卡券商户Logo */
    @Excel(name = "卡券商户Logo")
    private String logoUrl;

    /** 码型 */
    @Excel(name = "码型")
    private String codeType;

    /** 商户名 */
    @Excel(name = "商户名")
    private String brandName;

    /** 卡券名 */
    @Excel(name = "卡券名")
    private String title;

    /** 卡券颜色 */
    @Excel(name = "卡券颜色")
    private String color;

    /** 卡券使用提醒 */
    @Excel(name = "卡券使用提醒")
    private String notice;

    /** 卡券适用说明 */
    @Excel(name = "卡券适用说明")
    private String description;

    /** 卡券库存数量 */
    @Excel(name = "卡券库存数量")
    private Long quantity;

    /** 使用时间类型 */
    @Excel(name = "使用时间类型")
    private String type;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTimeStamp;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTimeStamp;

    /** 领取多少时间有效 */
    @Excel(name = "领取多少时间有效")
    private Long fixedTerm;

    /** 领取多少天开始生效 */
    @Excel(name = "领取多少天开始生效")
    private Long fixedBeginTerm;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLogoUrl(String logoUrl) 
    {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() 
    {
        return logoUrl;
    }
    public void setCodeType(String codeType) 
    {
        this.codeType = codeType;
    }

    public String getCodeType() 
    {
        return codeType;
    }
    public void setBrandName(String brandName) 
    {
        this.brandName = brandName;
    }

    public String getBrandName() 
    {
        return brandName;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }
    public void setNotice(String notice) 
    {
        this.notice = notice;
    }

    public String getNotice() 
    {
        return notice;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setBeginTimeStamp(Date beginTimeStamp) 
    {
        this.beginTimeStamp = beginTimeStamp;
    }

    public Date getBeginTimeStamp() 
    {
        return beginTimeStamp;
    }
    public void setEndTimeStamp(Date endTimeStamp) 
    {
        this.endTimeStamp = endTimeStamp;
    }

    public Date getEndTimeStamp() 
    {
        return endTimeStamp;
    }
    public void setFixedTerm(Long fixedTerm) 
    {
        this.fixedTerm = fixedTerm;
    }

    public Long getFixedTerm() 
    {
        return fixedTerm;
    }
    public void setFixedBeginTerm(Long fixedBeginTerm) 
    {
        this.fixedBeginTerm = fixedBeginTerm;
    }

    public Long getFixedBeginTerm() 
    {
        return fixedBeginTerm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("logoUrl", getLogoUrl())
            .append("codeType", getCodeType())
            .append("brandName", getBrandName())
            .append("title", getTitle())
            .append("color", getColor())
            .append("notice", getNotice())
            .append("description", getDescription())
            .append("quantity", getQuantity())
            .append("type", getType())
            .append("beginTimeStamp", getBeginTimeStamp())
            .append("endTimeStamp", getEndTimeStamp())
            .append("fixedTerm", getFixedTerm())
            .append("fixedBeginTerm", getFixedBeginTerm())
            .toString();
    }
}
