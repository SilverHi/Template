package com.ruoyi.project.cms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 借还管理对象 vcd_borrow_return
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public class VcdBorrowReturn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 借还编号 */
    private Long brId;

    /** 借还时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借还时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date brTime;

    /** 借还数量 */
    @Excel(name = "借还数量")
    private Long brNum;

    /** VCD编号 */
    @Excel(name = "VCD编号")
    private Long vcdId;

    /** 借出人员编号 */
    @Excel(name = "借出人员编号")
    private Long borrowerId;

    /** 归还人员编号 */
    @Excel(name = "归还人员编号")
    private Long returnerId;

    /** 借还状态，0表示借出，1表示归还 */
    @Excel(name = "借还状态，0表示借出，1表示归还")
    private Integer status;

    public void setBrId(Long brId) 
    {
        this.brId = brId;
    }

    public Long getBrId() 
    {
        return brId;
    }
    public void setBrTime(Date brTime) 
    {
        this.brTime = brTime;
    }

    public Date getBrTime() 
    {
        return brTime;
    }
    public void setBrNum(Long brNum) 
    {
        this.brNum = brNum;
    }

    public Long getBrNum() 
    {
        return brNum;
    }
    public void setVcdId(Long vcdId) 
    {
        this.vcdId = vcdId;
    }

    public Long getVcdId() 
    {
        return vcdId;
    }
    public void setBorrowerId(Long borrowerId) 
    {
        this.borrowerId = borrowerId;
    }

    public Long getBorrowerId() 
    {
        return borrowerId;
    }
    public void setReturnerId(Long returnerId) 
    {
        this.returnerId = returnerId;
    }

    public Long getReturnerId() 
    {
        return returnerId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("brId", getBrId())
            .append("brTime", getBrTime())
            .append("brNum", getBrNum())
            .append("vcdId", getVcdId())
            .append("borrowerId", getBorrowerId())
            .append("returnerId", getReturnerId())
            .append("status", getStatus())
            .toString();
    }
}
