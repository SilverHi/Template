package com.ruoyi.project.cms.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.cms.domain.CmsChannels;
import com.ruoyi.project.cms.service.ICmsChannelsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 频道Controller
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
@RestController
@RequestMapping("/cms/channels")
public class CmsChannelsController extends BaseController
{
    @Autowired
    private ICmsChannelsService cmsChannelsService;

    /**
     * 查询频道列表
     */
    @PreAuthorize("@ss.hasPermi('cms:channels:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsChannels cmsChannels)
    {
        startPage();
        List<CmsChannels> list = cmsChannelsService.selectCmsChannelsList(cmsChannels);
        return getDataTable(list);
    }

    /**
     * 导出频道列表
     */
    @PreAuthorize("@ss.hasPermi('cms:channels:export')")
    @Log(title = "频道", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsChannels cmsChannels)
    {
        List<CmsChannels> list = cmsChannelsService.selectCmsChannelsList(cmsChannels);
        ExcelUtil<CmsChannels> util = new ExcelUtil<CmsChannels>(CmsChannels.class);
        util.exportExcel(response, list, "频道数据");
    }

    /**
     * 获取频道详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:channels:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cmsChannelsService.selectCmsChannelsById(id));
    }

    /**
     * 新增频道
     */
    @PreAuthorize("@ss.hasPermi('cms:channels:add')")
    @Log(title = "频道", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsChannels cmsChannels)
    {
        return toAjax(cmsChannelsService.insertCmsChannels(cmsChannels));
    }

    /**
     * 修改频道
     */
    @PreAuthorize("@ss.hasPermi('cms:channels:edit')")
    @Log(title = "频道", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsChannels cmsChannels)
    {
        return toAjax(cmsChannelsService.updateCmsChannels(cmsChannels));
    }

    /**
     * 删除频道
     */
    @PreAuthorize("@ss.hasPermi('cms:channels:remove')")
    @Log(title = "频道", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cmsChannelsService.deleteCmsChannelsByIds(ids));
    }
}
