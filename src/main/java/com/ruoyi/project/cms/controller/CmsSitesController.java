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
import com.ruoyi.project.cms.domain.CmsSites;
import com.ruoyi.project.cms.service.ICmsSitesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 站点Controller
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
@RestController
@RequestMapping("/cms/sites")
public class CmsSitesController extends BaseController
{
    @Autowired
    private ICmsSitesService cmsSitesService;

    /**
     * 查询站点列表
     */
    @PreAuthorize("@ss.hasPermi('cms:sites:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsSites cmsSites)
    {
        startPage();
        List<CmsSites> list = cmsSitesService.selectCmsSitesList(cmsSites);
        return getDataTable(list);
    }

    /**
     * 导出站点列表
     */
    @PreAuthorize("@ss.hasPermi('cms:sites:export')")
    @Log(title = "站点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsSites cmsSites)
    {
        List<CmsSites> list = cmsSitesService.selectCmsSitesList(cmsSites);
        ExcelUtil<CmsSites> util = new ExcelUtil<CmsSites>(CmsSites.class);
        util.exportExcel(response, list, "站点数据");
    }

    /**
     * 获取站点详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:sites:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cmsSitesService.selectCmsSitesById(id));
    }

    /**
     * 新增站点
     */
    @PreAuthorize("@ss.hasPermi('cms:sites:add')")
    @Log(title = "站点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsSites cmsSites)
    {
        return toAjax(cmsSitesService.insertCmsSites(cmsSites));
    }

    /**
     * 修改站点
     */
    @PreAuthorize("@ss.hasPermi('cms:sites:edit')")
    @Log(title = "站点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsSites cmsSites)
    {
        return toAjax(cmsSitesService.updateCmsSites(cmsSites));
    }

    /**
     * 删除站点
     */
    @PreAuthorize("@ss.hasPermi('cms:sites:remove')")
    @Log(title = "站点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cmsSitesService.deleteCmsSitesByIds(ids));
    }
}
