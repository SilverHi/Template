package com.ruoyi.project.cms.service.impl;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cms.mapper.VcdInfoMapper;
import com.ruoyi.project.cms.domain.VcdInfo;
import com.ruoyi.project.cms.service.IVcdInfoService;

/**
 * VCD信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@Service
public class VcdInfoServiceImpl implements IVcdInfoService 
{
    @Autowired
    private VcdInfoMapper vcdInfoMapper;

    /**
     * 查询VCD信息
     * 
     * @param vcdId VCD信息主键
     * @return VCD信息
     */
    @Override
    public VcdInfo selectVcdInfoByVcdId(Long vcdId)
    {
        return vcdInfoMapper.selectVcdInfoByVcdId(vcdId);
    }

    /**
     * 查询VCD信息列表
     * 
     * @param vcdInfo VCD信息
     * @return VCD信息
     */
    @Override
    public List<VcdInfo> selectVcdInfoList(VcdInfo vcdInfo)
    {
        return vcdInfoMapper.selectVcdInfoList(vcdInfo);
    }

    /**
     * 新增VCD信息
     * 
     * @param vcdInfo VCD信息
     * @return 结果
     */
    @Override
    public int insertVcdInfo(VcdInfo vcdInfo)
    {
        //获取当前用户id
        vcdInfo.setOperatorId(SecurityUtils.getUserId());
        return vcdInfoMapper.insertVcdInfo(vcdInfo);
    }

    /**
     * 修改VCD信息
     * 
     * @param vcdInfo VCD信息
     * @return 结果
     */
    @Override
    public int updateVcdInfo(VcdInfo vcdInfo)
    {
        return vcdInfoMapper.updateVcdInfo(vcdInfo);
    }

    /**
     * 批量删除VCD信息
     * 
     * @param vcdIds 需要删除的VCD信息主键
     * @return 结果
     */
    @Override
    public int deleteVcdInfoByVcdIds(Long[] vcdIds)
    {
        return vcdInfoMapper.deleteVcdInfoByVcdIds(vcdIds);
    }

    /**
     * 删除VCD信息信息
     * 
     * @param vcdId VCD信息主键
     * @return 结果
     */
    @Override
    public int deleteVcdInfoByVcdId(Long vcdId)
    {
        return vcdInfoMapper.deleteVcdInfoByVcdId(vcdId);
    }
}
