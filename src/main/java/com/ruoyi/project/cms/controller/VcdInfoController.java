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
import com.ruoyi.project.cms.domain.VcdInfo;
import com.ruoyi.project.cms.service.IVcdInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * VCD信息Controller
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@RestController
@RequestMapping("/cms/info")
public class VcdInfoController extends BaseController
{
    @Autowired
    private IVcdInfoService vcdInfoService;

    /**
     * 查询VCD信息列表
     */
    @PreAuthorize("@ss.hasPermi('cms:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(VcdInfo vcdInfo)
    {
        startPage();
        List<VcdInfo> list = vcdInfoService.selectVcdInfoList(vcdInfo);
        return getDataTable(list);
    }

    /**
     * 导出VCD信息列表
     */
    @PreAuthorize("@ss.hasPermi('cms:info:export')")
    @Log(title = "VCD信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VcdInfo vcdInfo)
    {
        List<VcdInfo> list = vcdInfoService.selectVcdInfoList(vcdInfo);
        ExcelUtil<VcdInfo> util = new ExcelUtil<VcdInfo>(VcdInfo.class);
        util.exportExcel(response, list, "VCD信息数据");
    }

    /**
     * 获取VCD信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:info:query')")
    @GetMapping(value = "/{vcdId}")
    public AjaxResult getInfo(@PathVariable("vcdId") Long vcdId)
    {
        return AjaxResult.success(vcdInfoService.selectVcdInfoByVcdId(vcdId));
    }

    /**
     * 新增VCD信息
     */
    @PreAuthorize("@ss.hasPermi('cms:info:add')")
    @Log(title = "VCD信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VcdInfo vcdInfo)
    {
        return toAjax(vcdInfoService.insertVcdInfo(vcdInfo));
    }

    /**
     * 修改VCD信息
     */
    @PreAuthorize("@ss.hasPermi('cms:info:edit')")
    @Log(title = "VCD信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VcdInfo vcdInfo)
    {
        return toAjax(vcdInfoService.updateVcdInfo(vcdInfo));
    }

    /**
     * 删除VCD信息
     */
    @PreAuthorize("@ss.hasPermi('cms:info:remove')")
    @Log(title = "VCD信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{vcdIds}")
    public AjaxResult remove(@PathVariable Long[] vcdIds)
    {
        return toAjax(vcdInfoService.deleteVcdInfoByVcdIds(vcdIds));
    }
}
