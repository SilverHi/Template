package com.ruoyi.project.cms.service;

import java.util.List;
import com.ruoyi.project.cms.domain.VcdSale;

/**
 * 零售管理Service接口
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public interface IVcdSaleService 
{
    /**
     * 查询零售管理
     * 
     * @param saleId 零售管理主键
     * @return 零售管理
     */
    public VcdSale selectVcdSaleBySaleId(Long saleId);

    /**
     * 查询零售管理列表
     * 
     * @param vcdSale 零售管理
     * @return 零售管理集合
     */
    public List<VcdSale> selectVcdSaleList(VcdSale vcdSale);

    /**
     * 新增零售管理
     * 
     * @param vcdSale 零售管理
     * @return 结果
     */
    public int insertVcdSale(VcdSale vcdSale);

    /**
     * 修改零售管理
     * 
     * @param vcdSale 零售管理
     * @return 结果
     */
    public int updateVcdSale(VcdSale vcdSale);

    /**
     * 批量删除零售管理
     * 
     * @param saleIds 需要删除的零售管理主键集合
     * @return 结果
     */
    public int deleteVcdSaleBySaleIds(Long[] saleIds);

    /**
     * 删除零售管理信息
     * 
     * @param saleId 零售管理主键
     * @return 结果
     */
    public int deleteVcdSaleBySaleId(Long saleId);
}