package com.ruoyi.project.cms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cms.mapper.VcdBorrowReturnMapper;
import com.ruoyi.project.cms.domain.VcdBorrowReturn;
import com.ruoyi.project.cms.service.IVcdBorrowReturnService;

/**
 * 借还管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@Service
public class VcdBorrowReturnServiceImpl implements IVcdBorrowReturnService 
{
    @Autowired
    private VcdBorrowReturnMapper vcdBorrowReturnMapper;

    /**
     * 查询借还管理
     * 
     * @param brId 借还管理主键
     * @return 借还管理
     */
    @Override
    public VcdBorrowReturn selectVcdBorrowReturnByBrId(Long brId)
    {
        return vcdBorrowReturnMapper.selectVcdBorrowReturnByBrId(brId);
    }

    /**
     * 查询借还管理列表
     * 
     * @param vcdBorrowReturn 借还管理
     * @return 借还管理
     */
    @Override
    public List<VcdBorrowReturn> selectVcdBorrowReturnList(VcdBorrowReturn vcdBorrowReturn)
    {
        return vcdBorrowReturnMapper.selectVcdBorrowReturnList(vcdBorrowReturn);
    }

    /**
     * 新增借还管理
     * 
     * @param vcdBorrowReturn 借还管理
     * @return 结果
     */
    @Override
    public int insertVcdBorrowReturn(VcdBorrowReturn vcdBorrowReturn)
    {
        return vcdBorrowReturnMapper.insertVcdBorrowReturn(vcdBorrowReturn);
    }

    /**
     * 修改借还管理
     * 
     * @param vcdBorrowReturn 借还管理
     * @return 结果
     */
    @Override
    public int updateVcdBorrowReturn(VcdBorrowReturn vcdBorrowReturn)
    {
        return vcdBorrowReturnMapper.updateVcdBorrowReturn(vcdBorrowReturn);
    }

    /**
     * 批量删除借还管理
     * 
     * @param brIds 需要删除的借还管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdBorrowReturnByBrIds(Long[] brIds)
    {
        return vcdBorrowReturnMapper.deleteVcdBorrowReturnByBrIds(brIds);
    }

    /**
     * 删除借还管理信息
     * 
     * @param brId 借还管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdBorrowReturnByBrId(Long brId)
    {
        return vcdBorrowReturnMapper.deleteVcdBorrowReturnByBrId(brId);
    }
}
