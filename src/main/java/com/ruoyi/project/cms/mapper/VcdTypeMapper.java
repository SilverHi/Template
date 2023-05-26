package com.ruoyi.project.cms.mapper;

import java.util.List;
import com.ruoyi.project.cms.domain.VcdType;

/**
 * vcd类型管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public interface VcdTypeMapper 
{
    /**
     * 查询vcd类型管理
     * 
     * @param typeId vcd类型管理主键
     * @return vcd类型管理
     */
    public VcdType selectVcdTypeByTypeId(Long typeId);

    /**
     * 查询vcd类型管理列表
     * 
     * @param vcdType vcd类型管理
     * @return vcd类型管理集合
     */
    public List<VcdType> selectVcdTypeList(VcdType vcdType);

    /**
     * 新增vcd类型管理
     * 
     * @param vcdType vcd类型管理
     * @return 结果
     */
    public int insertVcdType(VcdType vcdType);

    /**
     * 修改vcd类型管理
     * 
     * @param vcdType vcd类型管理
     * @return 结果
     */
    public int updateVcdType(VcdType vcdType);

    /**
     * 删除vcd类型管理
     * 
     * @param typeId vcd类型管理主键
     * @return 结果
     */
    public int deleteVcdTypeByTypeId(Long typeId);

    /**
     * 批量删除vcd类型管理
     * 
     * @param typeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVcdTypeByTypeIds(Long[] typeIds);
}
