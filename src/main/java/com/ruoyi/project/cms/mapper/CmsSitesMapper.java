package com.ruoyi.project.cms.mapper;

import java.util.List;
import com.ruoyi.project.cms.domain.CmsSites;

/**
 * 站点Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
public interface CmsSitesMapper 
{
    /**
     * 查询站点
     * 
     * @param id 站点主键
     * @return 站点
     */
    public CmsSites selectCmsSitesById(Long id);

    /**
     * 查询站点列表
     * 
     * @param cmsSites 站点
     * @return 站点集合
     */
    public List<CmsSites> selectCmsSitesList(CmsSites cmsSites);

    /**
     * 新增站点
     * 
     * @param cmsSites 站点
     * @return 结果
     */
    public int insertCmsSites(CmsSites cmsSites);

    /**
     * 修改站点
     * 
     * @param cmsSites 站点
     * @return 结果
     */
    public int updateCmsSites(CmsSites cmsSites);

    /**
     * 删除站点
     * 
     * @param id 站点主键
     * @return 结果
     */
    public int deleteCmsSitesById(Long id);

    /**
     * 批量删除站点
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCmsSitesByIds(Long[] ids);
}
