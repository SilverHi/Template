package com.ruoyi.project.cms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cms.mapper.VcdSaleMapper;
import com.ruoyi.project.cms.domain.VcdSale;
import com.ruoyi.project.cms.service.IVcdSaleService;

/**
 * 零售管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@Service
public class VcdSaleServiceImpl implements IVcdSaleService 
{
    @Autowired
    private VcdSaleMapper vcdSaleMapper;

    /**
     * 查询零售管理
     * 
     * @param saleId 零售管理主键
     * @return 零售管理
     */
    @Override
    public VcdSale selectVcdSaleBySaleId(Long saleId)
    {
        return vcdSaleMapper.selectVcdSaleBySaleId(saleId);
    }

    /**
     * 查询零售管理列表
     * 
     * @param vcdSale 零售管理
     * @return 零售管理
     */
    @Override
    public List<VcdSale> selectVcdSaleList(VcdSale vcdSale)
    {
        return vcdSaleMapper.selectVcdSaleList(vcdSale);
    }

    /**
     * 新增零售管理
     * 
     * @param vcdSale 零售管理
     * @return 结果
     */
    @Override
    public int insertVcdSale(VcdSale vcdSale)
    {
        return vcdSaleMapper.insertVcdSale(vcdSale);
    }

    /**
     * 修改零售管理
     * 
     * @param vcdSale 零售管理
     * @return 结果
     */
    @Override
    public int updateVcdSale(VcdSale vcdSale)
    {
        return vcdSaleMapper.updateVcdSale(vcdSale);
    }

    /**
     * 批量删除零售管理
     * 
     * @param saleIds 需要删除的零售管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdSaleBySaleIds(Long[] saleIds)
    {
        return vcdSaleMapper.deleteVcdSaleBySaleIds(saleIds);
    }

    /**
     * 删除零售管理信息
     * 
     * @param saleId 零售管理主键
     * @return 结果
     */
    @Override
    public int deleteVcdSaleBySaleId(Long saleId)
    {
        return vcdSaleMapper.deleteVcdSaleBySaleId(saleId);
    }
}
