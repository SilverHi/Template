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
import com.ruoyi.project.cms.domain.VcdType;
import com.ruoyi.project.cms.service.IVcdTypeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * vcd类型管理Controller
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@RestController
@RequestMapping("/cms/type")
public class VcdTypeController extends BaseController
{
    @Autowired
    private IVcdTypeService vcdTypeService;

    /**
     * 查询vcd类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(VcdType vcdType)
    {
        startPage();
        List<VcdType> list = vcdTypeService.selectVcdTypeList(vcdType);
        return getDataTable(list);
    }

    /**
     * 导出vcd类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:type:export')")
    @Log(title = "vcd类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VcdType vcdType)
    {
        List<VcdType> list = vcdTypeService.selectVcdTypeList(vcdType);
        ExcelUtil<VcdType> util = new ExcelUtil<VcdType>(VcdType.class);
        util.exportExcel(response, list, "vcd类型管理数据");
    }

    /**
     * 获取vcd类型管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:type:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable("typeId") Long typeId)
    {
        return AjaxResult.success(vcdTypeService.selectVcdTypeByTypeId(typeId));
    }

    /**
     * 新增vcd类型管理
     */
    @PreAuthorize("@ss.hasPermi('cms:type:add')")
    @Log(title = "vcd类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VcdType vcdType)
    {
        return toAjax(vcdTypeService.insertVcdType(vcdType));
    }

    /**
     * 修改vcd类型管理
     */
    @PreAuthorize("@ss.hasPermi('cms:type:edit')")
    @Log(title = "vcd类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VcdType vcdType)
    {
        return toAjax(vcdTypeService.updateVcdType(vcdType));
    }

    /**
     * 删除vcd类型管理
     */
    @PreAuthorize("@ss.hasPermi('cms:type:remove')")
    @Log(title = "vcd类型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeIds}")
    public AjaxResult remove(@PathVariable Long[] typeIds)
    {
        return toAjax(vcdTypeService.deleteVcdTypeByTypeIds(typeIds));
    }
}
