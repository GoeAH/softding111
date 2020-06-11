package com.softding.business.tmsRate.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softding.common.annotation.Log;
import com.softding.common.enums.BusinessType;
import com.softding.business.tmsRate.domain.TmsRate;
import com.softding.business.tmsRate.service.ITmsRateService;
import com.softding.common.core.controller.BaseController;
import com.softding.common.core.domain.AjaxResult;
import com.softding.common.utils.poi.ExcelUtil;
import com.softding.common.core.page.TableDataInfo;

/**
 * 费率配置Controller
 * 
 * @author softding
 * @date 2020-05-22
 */
@Controller
@RequestMapping("/business/tmsRate")
public class TmsRateController extends BaseController
{
    private String prefix = "business/tmsRate";

    @Autowired
    private ITmsRateService tmsRateService;

    @RequiresPermissions("business:tmsRate:view")
    @GetMapping()
    public String tmsRate()
    {
        return prefix + "/tmsRate";
    }

    /**
     * 查询费率配置列表
     */
    @RequiresPermissions("business:tmsRate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TmsRate tmsRate)
    {
        startPage();
        List<TmsRate> list = tmsRateService.selectTmsRateList(tmsRate);
        return getDataTable(list);
    }

    /**
     * 导出费率配置列表
     */
    @RequiresPermissions("business:tmsRate:export")
    @Log(title = "费率配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TmsRate tmsRate)
    {
        List<TmsRate> list = tmsRateService.selectTmsRateList(tmsRate);
        ExcelUtil<TmsRate> util = new ExcelUtil<TmsRate>(TmsRate.class);
        return util.exportExcel(list, "tmsRate");
    }

    /**
     * 新增费率配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存费率配置
     */
    @RequiresPermissions("business:tmsRate:add")
    @Log(title = "费率配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TmsRate tmsRate)
    {
        return toAjax(tmsRateService.insertTmsRate(tmsRate));
    }

    /**
     * 修改费率配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TmsRate tmsRate = tmsRateService.selectTmsRateById(id);
        mmap.put("tmsRate", tmsRate);
        return prefix + "/edit";
    }

    /**
     * 修改保存费率配置
     */
    @RequiresPermissions("business:tmsRate:edit")
    @Log(title = "费率配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TmsRate tmsRate)
    {
        return toAjax(tmsRateService.updateTmsRate(tmsRate));
    }

    /**
     * 删除费率配置
     */
    @RequiresPermissions("business:tmsRate:remove")
    @Log(title = "费率配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tmsRateService.deleteTmsRateByIds(ids));
    }
}
