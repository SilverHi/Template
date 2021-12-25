package com.ruoyi.project.cms.mapper;

import java.util.List;
import com.ruoyi.project.cms.domain.CmsChannels;

/**
 * 频道Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
public interface CmsChannelsMapper 
{
    /**
     * 查询频道
     * 
     * @param id 频道主键
     * @return 频道
     */
    public CmsChannels selectCmsChannelsById(Long id);

    /**
     * 查询频道列表
     * 
     * @param cmsChannels 频道
     * @return 频道集合
     */
    public List<CmsChannels> selectCmsChannelsList(CmsChannels cmsChannels);

    /**
     * 新增频道
     * 
     * @param cmsChannels 频道
     * @return 结果
     */
    public int insertCmsChannels(CmsChannels cmsChannels);

    /**
     * 修改频道
     * 
     * @param cmsChannels 频道
     * @return 结果
     */
    public int updateCmsChannels(CmsChannels cmsChannels);

    /**
     * 删除频道
     * 
     * @param id 频道主键
     * @return 结果
     */
    public int deleteCmsChannelsById(Long id);

    /**
     * 批量删除频道
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCmsChannelsByIds(Long[] ids);
}
