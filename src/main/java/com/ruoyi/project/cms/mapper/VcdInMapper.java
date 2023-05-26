package com.ruoyi.project.cms.mapper;

import java.util.List;
import com.ruoyi.project.cms.domain.VcdIn;

/**
 * 入库管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public interface VcdInMapper 
{
    /**
     * 查询入库管理
     * 
     * @param inId 入库管理主键
     * @return 入库管理
     */
    public VcdIn selectVcdInByInId(Long inId);

    /**
     * 查询入库管理列表
     * 
     * @param vcdIn 入库管理
     * @return 入库管理集合
     */
    public List<VcdIn> selectVcdInList(VcdIn vcdIn);

    /**
     * 新增入库管理
     * 
     * @param vcdIn 入库管理
     * @return 结果
     */
    public int insertVcdIn(VcdIn vcdIn);

    /**
     * 修改入库管理
     * 
     * @param vcdIn 入库管理
     * @return 结果
     */
    public int updateVcdIn(VcdIn vcdIn);

    /**
     * 删除入库管理
     * 
     * @param inId 入库管理主键
     * @return 结果
     */
    public int deleteVcdInByInId(Long inId);

    /**
     * 批量删除入库管理
     * 
     * @param inIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVcdInByInIds(Long[] inIds);
}
