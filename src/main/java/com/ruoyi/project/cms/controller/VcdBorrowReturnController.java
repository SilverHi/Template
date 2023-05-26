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
import com.ruoyi.project.cms.domain.VcdBorrowReturn;
import com.ruoyi.project.cms.service.IVcdBorrowReturnService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 借还管理Controller
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@RestController
@RequestMapping("/cms/return")
public class VcdBorrowReturnController extends BaseController
{
    @Autowired
    private IVcdBorrowReturnService vcdBorrowReturnService;

    /**
     * 查询借还管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:return:list')")
    @GetMapping("/list")
    public TableDataInfo list(VcdBorrowReturn vcdBorrowReturn)
    {
        startPage();
        List<VcdBorrowReturn> list = vcdBorrowReturnService.selectVcdBorrowReturnList(vcdBorrowReturn);
        return getDataTable(list);
    }

    /**
     * 导出借还管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:return:export')")
    @Log(title = "借还管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VcdBorrowReturn vcdBorrowReturn)
    {
        List<VcdBorrowReturn> list = vcdBorrowReturnService.selectVcdBorrowReturnList(vcdBorrowReturn);
        ExcelUtil<VcdBorrowReturn> util = new ExcelUtil<VcdBorrowReturn>(VcdBorrowReturn.class);
        util.exportExcel(response, list, "借还管理数据");
    }

    /**
     * 获取借还管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:return:query')")
    @GetMapping(value = "/{brId}")
    public AjaxResult getInfo(@PathVariable("brId") Long brId)
    {
        return AjaxResult.success(vcdBorrowReturnService.selectVcdBorrowReturnByBrId(brId));
    }

    /**
     * 新增借还管理
     */
    @PreAuthorize("@ss.hasPermi('cms:return:add')")
    @Log(title = "借还管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VcdBorrowReturn vcdBorrowReturn)
    {
        return toAjax(vcdBorrowReturnService.insertVcdBorrowReturn(vcdBorrowReturn));
    }

    /**
     * 修改借还管理
     */
    @PreAuthorize("@ss.hasPermi('cms:return:edit')")
    @Log(title = "借还管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VcdBorrowReturn vcdBorrowReturn)
    {
        return toAjax(vcdBorrowReturnService.updateVcdBorrowReturn(vcdBorrowReturn));
    }

    /**
     * 删除借还管理
     */
    @PreAuthorize("@ss.hasPermi('cms:return:remove')")
    @Log(title = "借还管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{brIds}")
    public AjaxResult remove(@PathVariable Long[] brIds)
    {
        return toAjax(vcdBorrowReturnService.deleteVcdBorrowReturnByBrIds(brIds));
    }
}
