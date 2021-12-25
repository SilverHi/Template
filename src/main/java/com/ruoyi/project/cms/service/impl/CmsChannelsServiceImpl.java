package com.ruoyi.project.cms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.cms.mapper.CmsChannelsMapper;
import com.ruoyi.project.cms.domain.CmsChannels;
import com.ruoyi.project.cms.service.ICmsChannelsService;

/**
 * 频道Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
@Service
public class CmsChannelsServiceImpl implements ICmsChannelsService 
{
    @Autowired
    private CmsChannelsMapper cmsChannelsMapper;

    /**
     * 查询频道
     * 
     * @param id 频道主键
     * @return 频道
     */
    @Override
    public CmsChannels selectCmsChannelsById(Long id)
    {
        return cmsChannelsMapper.selectCmsChannelsById(id);
    }

    /**
     * 查询频道列表
     * 
     * @param cmsChannels 频道
     * @return 频道
     */
    @Override
    public List<CmsChannels> selectCmsChannelsList(CmsChannels cmsChannels)
    {
        return cmsChannelsMapper.selectCmsChannelsList(cmsChannels);
    }

    /**
     * 新增频道
     * 
     * @param cmsChannels 频道
     * @return 结果
     */
    @Override
    public int insertCmsChannels(CmsChannels cmsChannels)
    {
        return cmsChannelsMapper.insertCmsChannels(cmsChannels);
    }

    /**
     * 修改频道
     * 
     * @param cmsChannels 频道
     * @return 结果
     */
    @Override
    public int updateCmsChannels(CmsChannels cmsChannels)
    {
        return cmsChannelsMapper.updateCmsChannels(cmsChannels);
    }

    /**
     * 批量删除频道
     * 
     * @param ids 需要删除的频道主键
     * @return 结果
     */
    @Override
    public int deleteCmsChannelsByIds(Long[] ids)
    {
        return cmsChannelsMapper.deleteCmsChannelsByIds(ids);
    }

    /**
     * 删除频道信息
     * 
     * @param id 频道主键
     * @return 结果
     */
    @Override
    public int deleteCmsChannelsById(Long id)
    {
        return cmsChannelsMapper.deleteCmsChannelsById(id);
    }
}
