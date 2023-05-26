package com.ruoyi.project.cms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cms.mapper.VcdTypeMapper;
import com.ruoyi.project.cms.domain.VcdType;
import com.ruoyi.project.cms.service.IVcdTypeService;

/**
 * vcd类型管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@Service
public class VcdTypeServiceImpl implements IVcdTypeService 
{
    @Autowired
    private VcdTypeMapper vcdTypeMapper;

    /**
     * 查询vcd类型管理
     * 
     * @param typeId vcd类型管理主键
     * @return vcd类型管理
     */
    @Override
    public VcdType selectVcdTypeByTypeId(Long typeId)
    {
        return vcdTypeMapper.selectVcdTypeByTypeId(typeId);
    }

    /**
     * 查询vcd类型管理列表
     * 
     * @param vcdType vcd类型管理
     * @return vcd类型管理
     */
    @Override
    public List<VcdType> selectVcdTypeList(VcdType vcdType)
    {
        return vcdTypeMapper.selectVcdTypeList(vcdType);
    }

    /**
     * 新增vcd类型管理
     * 
     * @param vcdType vcd类型管理
     * @return 结果
     */
    @Override
    public int insertVcdType(VcdType vcdType)
    {
        return vcdTypeMapper.insertVcdType(vcdType);
    }

    /**
     * 修改vcd类型管理
     * 
     * @param vcdType vcd类型管理
     * @return 结果
     */
    @Override
    public int updateVcdType(VcdType vcdType)
    {
        return vcdTypeMapper.updateVcdType(vcdType);
    }

    /**
     * 批量删除vcd类型管理
     * 
     * @param typeIds 需要删除的vcd类型管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdTypeByTypeIds(Long[] typeIds)
    {
        return vcdTypeMapper.deleteVcdTypeByTypeIds(typeIds);
    }

    /**
     * 删除vcd类型管理信息
     * 
     * @param typeId vcd类型管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdTypeByTypeId(Long typeId)
    {
        return vcdTypeMapper.deleteVcdTypeByTypeId(typeId);
    }
}
