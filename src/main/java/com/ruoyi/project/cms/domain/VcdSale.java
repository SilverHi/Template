package com.ruoyi.project.cms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 零售管理对象 vcd_sale
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public class VcdSale extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售编号 */
    private Long saleId;

    /** 销售时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date saleTime;

    /** 销售数量 */
    @Excel(name = "销售数量")
    private Long saleNum;

    /** VCD编号 */
    @Excel(name = "VCD编号")
    private Long vcdId;

    /** 操作人员编号 */
    @Excel(name = "操作人员编号")
    private Long operatorId;

    public void setSaleId(Long saleId) 
    {
        this.saleId = saleId;
    }

    public Long getSaleId() 
    {
        return saleId;
    }
    public void setSaleTime(Date saleTime) 
    {
        this.saleTime = saleTime;
    }

    public Date getSaleTime() 
    {
        return saleTime;
    }
    public void setSaleNum(Long saleNum) 
    {
        this.saleNum = saleNum;
    }

    public Long getSaleNum() 
    {
        return saleNum;
    }
    public void setVcdId(Long vcdId) 
    {
        this.vcdId = vcdId;
    }

    public Long getVcdId() 
    {
        return vcdId;
    }
    public void setOperatorId(Long operatorId) 
    {
        this.operatorId = operatorId;
    }

    public Long getOperatorId() 
    {
        return operatorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("saleId", getSaleId())
            .append("saleTime", getSaleTime())
            .append("saleNum", getSaleNum())
            .append("vcdId", getVcdId())
            .append("operatorId", getOperatorId())
            .toString();
    }
}
