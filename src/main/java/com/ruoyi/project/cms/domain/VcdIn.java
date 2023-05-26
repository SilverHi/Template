package com.ruoyi.project.cms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 入库管理对象 vcd_in
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public class VcdIn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库编号 */
    private Long inId;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inTime;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long inNum;

    /** VCD编号 */
    @Excel(name = "VCD编号")
    private Long vcdId;

    /** 操作人员编号 */
    @Excel(name = "操作人员编号")
    private Long operatorId;

    public void setInId(Long inId) 
    {
        this.inId = inId;
    }

    public Long getInId() 
    {
        return inId;
    }
    public void setInTime(Date inTime) 
    {
        this.inTime = inTime;
    }

    public Date getInTime() 
    {
        return inTime;
    }
    public void setInNum(Long inNum) 
    {
        this.inNum = inNum;
    }

    public Long getInNum() 
    {
        return inNum;
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
            .append("inId", getInId())
            .append("inTime", getInTime())
            .append("inNum", getInNum())
            .append("vcdId", getVcdId())
            .append("operatorId", getOperatorId())
            .toString();
    }
}
