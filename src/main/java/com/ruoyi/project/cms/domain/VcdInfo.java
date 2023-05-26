package com.ruoyi.project.cms.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * VCD信息对象 vcd_info
 *
 * @author ruoyi
 * @date 2023-05-26
 */
public class VcdInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** VCD编号 */
    private Long vcdId;

    /** VCD名称 */
    @Excel(name = "VCD名称")
    private String vcdName;

    /** VCD类型编号 */
    @Excel(name = "VCD类型编号")
    private Long typeId;

    /** VCD价格 */
    @Excel(name = "VCD价格")
    private BigDecimal price;

    /** 操作人员编号 */
    @Excel(name = "操作人员编号")
    private Long operatorId;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long num;

    public void setVcdId(Long vcdId)
    {
        this.vcdId = vcdId;
    }

    public Long getVcdId()
    {
        return vcdId;
    }
    public void setVcdName(String vcdName)
    {
        this.vcdName = vcdName;
    }

    public String getVcdName()
    {
        return vcdName;
    }
    public void setTypeId(Long typeId)
    {
        this.typeId = typeId;
    }

    public Long getTypeId()
    {
        return typeId;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setOperatorId(Long operatorId)
    {
        this.operatorId = operatorId;
    }

    public Long getOperatorId()
    {
        return operatorId;
    }
    public void setNum(Long num)
    {
        this.num = num;
    }

    public Long getNum()
    {
        return num;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("vcdId", getVcdId())
                .append("vcdName", getVcdName())
                .append("typeId", getTypeId())
                .append("price", getPrice())
                .append("operatorId", getOperatorId())
                .append("num", getNum())
                .toString();
    }
}