package com.ruoyi.project.cms.service.impl;

import java.util.List;

import com.sun.jna.platform.win32.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cms.mapper.CmsSitesMapper;
import com.ruoyi.project.cms.domain.CmsSites;
import com.ruoyi.project.cms.service.ICmsSitesService;

/**
 * 站点Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
@Service
public class CmsSitesServiceImpl implements ICmsSitesService 
{
    @Autowired
    private CmsSitesMapper cmsSitesMapper;

    /**
     * 查询站点
     * 
     * @param id 站点主键
     * @return 站点
     */
    @Override
    public CmsSites selectCmsSitesById(Long id)
    {
        return cmsSitesMapper.selectCmsSitesById(id);
    }

    /**
     * 查询站点列表
     * 
     * @param cmsSites 站点
     * @return 站点
     */
    @Override
    public List<CmsSites> selectCmsSitesList(CmsSites cmsSites)
    {
        return cmsSitesMapper.selectCmsSitesList(cmsSites);
    }

    /**
     * 新增站点
     * 
     * @param cmsSites 站点
     * @return 结果
     */
    @Override
    public int insertCmsSites(CmsSites cmsSites)
    {
        //处理guid
        cmsSites.setGuid(Guid.GUID.newGuid().toGuidString());

        return cmsSitesMapper.insertCmsSites(cmsSites);
    }

    /**
     * 修改站点
     * 
     * @param cmsSites 站点
     * @return 结果
     */
    @Override
    public int updateCmsSites(CmsSites cmsSites)
    {
        return cmsSitesMapper.updateCmsSites(cmsSites);
    }

    /**
     * 批量删除站点
     * 
     * @param ids 需要删除的站点主键
     * @return 结果
     */
    @Override
    public int deleteCmsSitesByIds(Long[] ids)
    {
        return cmsSitesMapper.deleteCmsSitesByIds(ids);
    }

    /**
     * 删除站点信息
     * 
     * @param id 站点主键
     * @return 结果
     */
    @Override
    public int deleteCmsSitesById(Long id)
    {
        return cmsSitesMapper.deleteCmsSitesById(id);
    }
}
