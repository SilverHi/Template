package com.ruoyi.project.cms.service;

import java.util.List;
import com.ruoyi.project.cms.domain.VcdBorrowReturn;

/**
 * 借还管理Service接口
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public interface IVcdBorrowReturnService 
{
    /**
     * 查询借还管理
     * 
     * @param brId 借还管理主键
     * @return 借还管理
     */
    public VcdBorrowReturn selectVcdBorrowReturnByBrId(Long brId);

    /**
     * 查询借还管理列表
     * 
     * @param vcdBorrowReturn 借还管理
     * @return 借还管理集合
     */
    public List<VcdBorrowReturn> selectVcdBorrowReturnList(VcdBorrowReturn vcdBorrowReturn);

    /**
     * 新增借还管理
     * 
     * @param vcdBorrowReturn 借还管理
     * @return 结果
     */
    public int insertVcdBorrowReturn(VcdBorrowReturn vcdBorrowReturn);

    /**
     * 修改借还管理
     * 
     * @param vcdBorrowReturn 借还管理
     * @return 结果
     */
    public int updateVcdBorrowReturn(VcdBorrowReturn vcdBorrowReturn);

    /**
     * 批量删除借还管理
     * 
     * @param brIds 需要删除的借还管理主键集合
     * @return 结果
     */
    public int deleteVcdBorrowReturnByBrIds(Long[] brIds);

    /**
     * 删除借还管理信息
     * 
     * @param brId 借还管理主键
     * @return 结果
     */
    public int deleteVcdBorrowReturnByBrId(Long brId);
}
