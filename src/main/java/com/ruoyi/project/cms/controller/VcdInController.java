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
import com.ruoyi.project.cms.domain.VcdIn;
import com.ruoyi.project.cms.service.IVcdInService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 入库管理Controller
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@RestController
@RequestMapping("/cms/in")
public class VcdInController extends BaseController
{
    @Autowired
    private IVcdInService vcdInService;

    /**
     * 查询入库管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:in:list')")
    @GetMapping("/list")
    public TableDataInfo list(VcdIn vcdIn)
    {
        startPage();
        List<VcdIn> list = vcdInService.selectVcdInList(vcdIn);
        return getDataTable(list);
    }

    /**
     * 导出入库管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:in:export')")
    @Log(title = "入库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VcdIn vcdIn)
    {
        List<VcdIn> list = vcdInService.selectVcdInList(vcdIn);
        ExcelUtil<VcdIn> util = new ExcelUtil<VcdIn>(VcdIn.class);
        util.exportExcel(response, list, "入库管理数据");
    }

    /**
     * 获取入库管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:in:query')")
    @GetMapping(value = "/{inId}")
    public AjaxResult getInfo(@PathVariable("inId") Long inId)
    {
        return AjaxResult.success(vcdInService.selectVcdInByInId(inId));
    }

    /**
     * 新增入库管理
     */
    @PreAuthorize("@ss.hasPermi('cms:in:add')")
    @Log(title = "入库管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VcdIn vcdIn)
    {
        return toAjax(vcdInService.insertVcdIn(vcdIn));
    }

    /**
     * 修改入库管理
     */
    @PreAuthorize("@ss.hasPermi('cms:in:edit')")
    @Log(title = "入库管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VcdIn vcdIn)
    {
        return toAjax(vcdInService.updateVcdIn(vcdIn));
    }

    /**
     * 删除入库管理
     */
    @PreAuthorize("@ss.hasPermi('cms:in:remove')")
    @Log(title = "入库管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inIds}")
    public AjaxResult remove(@PathVariable Long[] inIds)
    {
        return toAjax(vcdInService.deleteVcdInByInIds(inIds));
    }
}
