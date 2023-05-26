package com.ruoyi.project.cms.service;

import java.util.List;
import com.ruoyi.project.cms.domain.VcdInfo;

/**
 * VCD信息Service接口
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public interface IVcdInfoService 
{
    /**
     * 查询VCD信息
     * 
     * @param vcdId VCD信息主键
     * @return VCD信息
     */
    public VcdInfo selectVcdInfoByVcdId(Long vcdId);

    /**
     * 查询VCD信息列表
     * 
     * @param vcdInfo VCD信息
     * @return VCD信息集合
     */
    public List<VcdInfo> selectVcdInfoList(VcdInfo vcdInfo);

    /**
     * 新增VCD信息
     * 
     * @param vcdInfo VCD信息
     * @return 结果
     */
    public int insertVcdInfo(VcdInfo vcdInfo);

    /**
     * 修改VCD信息
     * 
     * @param vcdInfo VCD信息
     * @return 结果
     */
    public int updateVcdInfo(VcdInfo vcdInfo);

    /**
     * 批量删除VCD信息
     * 
     * @param vcdIds 需要删除的VCD信息主键集合
     * @return 结果
     */
    public int deleteVcdInfoByVcdIds(Long[] vcdIds);

    /**
     * 删除VCD信息信息
     * 
     * @param vcdId VCD信息主键
     * @return 结果
     */
    public int deleteVcdInfoByVcdId(Long vcdId);
}
