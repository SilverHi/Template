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
import com.ruoyi.project.cms.domain.VcdSale;
import com.ruoyi.project.cms.service.IVcdSaleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 零售管理Controller
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@RestController
@RequestMapping("/cms/sale")
public class VcdSaleController extends BaseController
{
    @Autowired
    private IVcdSaleService vcdSaleService;

    /**
     * 查询零售管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:sale:list')")
    @GetMapping("/list")
    public TableDataInfo list(VcdSale vcdSale)
    {
        startPage();
        List<VcdSale> list = vcdSaleService.selectVcdSaleList(vcdSale);
        return getDataTable(list);
    }

    /**
     * 导出零售管理列表
     */
    @PreAuthorize("@ss.hasPermi('cms:sale:export')")
    @Log(title = "零售管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VcdSale vcdSale)
    {
        List<VcdSale> list = vcdSaleService.selectVcdSaleList(vcdSale);
        ExcelUtil<VcdSale> util = new ExcelUtil<VcdSale>(VcdSale.class);
        util.exportExcel(response, list, "零售管理数据");
    }

    /**
     * 获取零售管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cms:sale:query')")
    @GetMapping(value = "/{saleId}")
    public AjaxResult getInfo(@PathVariable("saleId") Long saleId)
    {
        return AjaxResult.success(vcdSaleService.selectVcdSaleBySaleId(saleId));
    }

    /**
     * 新增零售管理
     */
    @PreAuthorize("@ss.hasPermi('cms:sale:add')")
    @Log(title = "零售管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VcdSale vcdSale)
    {
        return toAjax(vcdSaleService.insertVcdSale(vcdSale));
    }

    /**
     * 修改零售管理
     */
    @PreAuthorize("@ss.hasPermi('cms:sale:edit')")
    @Log(title = "零售管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VcdSale vcdSale)
    {
        return toAjax(vcdSaleService.updateVcdSale(vcdSale));
    }

    /**
     * 删除零售管理
     */
    @PreAuthorize("@ss.hasPermi('cms:sale:remove')")
    @Log(title = "零售管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{saleIds}")
    public AjaxResult remove(@PathVariable Long[] saleIds)
    {
        return toAjax(vcdSaleService.deleteVcdSaleBySaleIds(saleIds));
    }
}
