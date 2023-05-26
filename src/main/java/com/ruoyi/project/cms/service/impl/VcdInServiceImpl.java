package com.ruoyi.project.cms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cms.mapper.VcdInMapper;
import com.ruoyi.project.cms.domain.VcdIn;
import com.ruoyi.project.cms.service.IVcdInService;

/**
 * 入库管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@Service
public class VcdInServiceImpl implements IVcdInService 
{
    @Autowired
    private VcdInMapper vcdInMapper;

    /**
     * 查询入库管理
     * 
     * @param inId 入库管理主键
     * @return 入库管理
     */
    @Override
    public VcdIn selectVcdInByInId(Long inId)
    {
        return vcdInMapper.selectVcdInByInId(inId);
    }

    /**
     * 查询入库管理列表
     * 
     * @param vcdIn 入库管理
     * @return 入库管理
     */
    @Override
    public List<VcdIn> selectVcdInList(VcdIn vcdIn)
    {
        return vcdInMapper.selectVcdInList(vcdIn);
    }

    /**
     * 新增入库管理
     * 
     * @param vcdIn 入库管理
     * @return 结果
     */
    @Override
    public int insertVcdIn(VcdIn vcdIn)
    {
        return vcdInMapper.insertVcdIn(vcdIn);
    }

    /**
     * 修改入库管理
     * 
     * @param vcdIn 入库管理
     * @return 结果
     */
    @Override
    public int updateVcdIn(VcdIn vcdIn)
    {
        return vcdInMapper.updateVcdIn(vcdIn);
    }

    /**
     * 批量删除入库管理
     * 
     * @param inIds 需要删除的入库管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdInByInIds(Long[] inIds)
    {
        return vcdInMapper.deleteVcdInByInIds(inIds);
    }

    /**
     * 删除入库管理信息
     * 
     * @param inId 入库管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdInByInId(Long inId)
    {
        return vcdInMapper.deleteVcdInByInId(inId);
    }
}
