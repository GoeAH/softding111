package com.softding.business.tmsRate.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.softding.common.annotation.Excel;
import com.softding.common.core.domain.BaseEntity;

/**
 * 费率配置对象 tms_rate
 * 
 * @author softding
 * @date 2020-05-22
 */

@TableName("tms_rate")
public class TmsRate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 公司ID */
    @Excel(name = "公司ID")
    private Long companyId;

    /** 费率类型：B-保费费率；D-代收款费率 */
    @Excel(name = "费率类型：B-保费费率；D-代收款费率")
    private String rateType;

    /** 费率（%） */
    @Excel(name = "费率", readConverterExp = "%=")
    private Double rate;

    private String remark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setRateType(String rateType) 
    {
        this.rateType = rateType;
    }

    public String getRateType() 
    {
        return rateType;
    }
    public void setRate(Double rate) 
    {
        this.rate = rate;
    }

    public Double getRate() 
    {
        return rate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("companyId", getCompanyId())
            .append("rateType", getRateType())
            .append("rate", getRate())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
